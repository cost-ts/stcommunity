package org.st.community.provider;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;
import org.st.community.dto.AccessTokenDTO;
import org.st.community.dto.GithubUser;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: Github授权支持 - 获取token
 * User: ST
 * Date: 2020-09-04
 * Time: 0:35
 */
@Component
public class GithubProvider {

    /**
     * 获取github token
     *
     * @return token
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {

        MediaType mediaType = MediaType.get("application/json; charset=utf8");
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();

        try (
                Response response = okHttpClient.newCall(request).execute();
        ) {
            // 获取token
            String token = response.body().string().split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取Github返回的用户信息
     *
     * @param token
     * @return GithubUser
     */
    public GithubUser getUser(String token) {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + token)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String string = response.body().string();
            // 转换成对象
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
