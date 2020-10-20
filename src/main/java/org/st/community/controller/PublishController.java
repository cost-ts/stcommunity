package org.st.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.st.community.mapper.QuestionMapper;
import org.st.community.mapper.UserMapper;
import org.st.community.model.Question;
import org.st.community.model.User;
import org.st.community.utils.ObjectUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 发布文章功能
 * @author: ST
 * @Date: 2020-09-29
 * @Time: 17:01
 */
@Controller
public class PublishController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    private final String TOKEN = "token";

    /**
     * 渲染publish页面
     *
     * @return publish页面
     */
    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    /**
     * 发布问题
     *
     * @param title       问题标题
     * @param description 问题描述
     * @param tag         标签
     * @param request     http请求
     * @param model       model
     * @return 跳转页面
     */
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model
    ) {
        // 判断用户是否登录
        User user = null;

        Cookie[] cookies = request.getCookies();
        if (ObjectUtils.isNotNull(cookies)) {
            for (Cookie cookie : cookies) {
                // 判断cookie中是否携带有token
                if (TOKEN.equals(cookie.getName())) {
                    String token = cookie.getValue();
                    // 通过token或许登录用户信息
                    user = userMapper.findByToken(token);
                    // 判断用户是否存在
                    if (ObjectUtils.isNotNull(user)) {
                        HttpSession session = request.getSession();
                        // 将user写入session(保持登录态)
                        session.setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        if (ObjectUtils.isNull(user)) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        // 填充数据
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());

        questionMapper.create(question);

        return "redirect:/";
    }
}
