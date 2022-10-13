package com.zdotavv.enterprise_homework6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {
    @RequestMapping(method = RequestMethod.GET)
    public String mainIndex(Model model) {
        String message = "Online shop start page";
        model.addAttribute("message", message);
        return "mainIndex";
    }

}
