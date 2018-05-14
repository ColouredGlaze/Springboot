package com.springboot.TemplateController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by MingT on 2017/7/12.
 */
@Controller
public class ThymeleafController {
    @RequestMapping("/thymeleafHtml")
    public String thymeleafHtml(Map<String, Object> map) {
        map.put("hello", "from TemplateController.ThymeleafController.thymeleafHtml");
        return "/thymeleaf";
    }
}
