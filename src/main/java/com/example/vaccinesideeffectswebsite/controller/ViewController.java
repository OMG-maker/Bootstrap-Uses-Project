package com.example.vaccinesideeffectswebsite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @RequestMapping({"/index"})

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String main() {
        return "index";
    }

// @RequestMapping({"/index2"})
    @RequestMapping(value="/index2", method= RequestMethod.GET)
    public String index2() {
        return "index2";
    }

//    @RequestMapping({"/login"})
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping({"/join"})
//    public String register() {
//        return "join";
//    }


    @RequestMapping(value="/layout", method= RequestMethod.GET)
    public String layout() {
        return "layout/defaultLayout";
    }
}
