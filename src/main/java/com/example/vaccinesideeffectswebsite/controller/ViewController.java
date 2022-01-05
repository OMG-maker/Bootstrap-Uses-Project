package com.example.vaccinesideeffectswebsite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/index"})
    public String main() {
        return "index";
    }

    @RequestMapping({"/index2"})
    public String index2() {
        return "index2";
    }


    @RequestMapping({"/login"})
    public String login() {
        return "login";
    }

    @RequestMapping({"/register"})
    public String register() {
        return "register";
    }

    @RequestMapping({"/layout"})
    public String layout() {
        return "layout/defaultLayout";
    }
}
