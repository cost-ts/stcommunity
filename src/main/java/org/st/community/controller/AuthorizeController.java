package org.st.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.st.community.dto.AccessTokenDTO;
import org.st.community.dto.GithubUser;
import org.st.community.provider.GithubProvider;
import org.st.community.utils.ObjectUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description: 授权回调页面
 * User: ST
 * Date: 2020-09-04
 * Time: 0:21
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String secret;
    @Value("${github.redirect.uri}")
    private String uri;

    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request
    ) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(uri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        // 将用户信息写入session
        if (ObjectUtils.isNotNull(user)) {
            // 写入session并返回首页
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        }else {
            // 返回登录页
            return "redirect:/";
        }
    }
}
