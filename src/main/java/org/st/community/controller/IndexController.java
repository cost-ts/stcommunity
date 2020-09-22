package org.st.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 * Description: 项目入口请求
 * User: ST
 * Date: 2020-09-01
 * Time: 23:52
 */
@Controller
public class IndexController {

    /**
     * 访问根目录 /
     * @return index页面
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
