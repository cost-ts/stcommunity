package org.st.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.st.community.dto.AccessTokenDTO;
import org.st.community.dto.GithubUser;
import org.st.community.mapper.UserMapper;
import org.st.community.model.User;
import org.st.community.provider.GithubProvider;
import org.st.community.utils.ObjectUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 授权回调页面
 * @author: ST
 * @Date: 2020-09-04 0:21
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String secret;
    @Value("${github.redirect.uri}")
    private String uri;

    /**
     * 回调/callback获取token
     *
     * @param code     返回的code
     * @param state    状态码
     * @param response http响应
     * @return 返回首页
     */
    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response
    ) {
        // 填充token
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(uri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        // 将用户信息写入session
        if (ObjectUtils.isNotNull(githubUser) && ObjectUtils.isNotNull(githubUser.getId())) {
            // 将用户信息写入数据库
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setBio(githubUser.getBio());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userMapper.insertUser(user);
            // 将token写入cookie中
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            // 返回登录页
            return "redirect:/";
        }
    }
}
