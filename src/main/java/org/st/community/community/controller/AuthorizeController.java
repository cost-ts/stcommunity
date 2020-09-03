package org.st.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.st.community.community.dto.AccessTokenDTO;
import org.st.community.community.dto.GithubUser;
import org.st.community.community.provider.GithubProvider;

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

    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state
                           ){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("Iv1.f1e6e50b739e76ec");
        accessTokenDTO.setClient_secret("46e0609c98f76e8fcca44ecbf7f46dea92c167db");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(code);
        return "index";
    }
}
