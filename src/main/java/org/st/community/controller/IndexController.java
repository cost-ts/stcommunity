package org.st.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.st.community.mapper.UserMapper;
import org.st.community.model.User;
import org.st.community.utils.ObjectUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 项目入口请求
 * @author: ST
 * @Date: 2020-09-01
 * @Time: 23:52
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    private final String TOKEN = "token";

    /**
     * 访问首页
     * 如果浏览器中存在cookie且匹配数据库中数据,在首页展示用户信息
     *
     * @return index页面
     */
    @GetMapping("/")
    public String index(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (ObjectUtils.isNotNull(cookies)) {
            for (Cookie cookie : cookies) {
                // 判断cookie中是否携带有token
                if (TOKEN.equals(cookie.getName())) {

                    String token = cookie.getValue();
                    // 通过token或许登录用户信息
                    User user = userMapper.findByToken(token);
                    // 判断用户是否存在
                    if (ObjectUtils.isNotNull(user)) {

                        HttpSession session = request.getSession();
                        // 将user写入session(保持登录态)
                        session.setAttribute("user", user);
                        // 设置session过期时间(这里设置为7天)
                        session.setMaxInactiveInterval(60 * 60 * 24 * 7);
                    }
                    break;
                }
            }
        }
        return "index";
    }
}
