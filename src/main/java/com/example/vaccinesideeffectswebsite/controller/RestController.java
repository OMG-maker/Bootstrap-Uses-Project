package com.example.vaccinesideeffectswebsite.controller;

import com.example.vaccinesideeffectswebsite.service.AccountService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequestMapping({"/account"})
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountService accountService;

    @RequestMapping({"/logout"})
    public ModelAndView logOut(HttpServletRequest request) throws Exception {
        logger.info("logoutMainGET 메서드 진입");

        HttpSession session = request.getSession();
        session.invalidate();
        ModelAndView mv = new ModelAndView("/login");
        return mv;
    }

    @RequestMapping({"/login"})
    public JSONObject login(@RequestParam("userEmail") String userEmail,
                            @RequestParam("userPassword") String userPassword,
                            HttpServletRequest request
    ) throws Exception {
        logger.info("userEmail : {}", userEmail);

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("userEmail", userEmail);
        paramMap.put("userPassword", userPassword);
        HashMap<String, Object> resultMap = accountService.findAccount(paramMap);

        if (resultMap != null) {
            logger.info("로그인 처리");
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", userEmail);
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("data", resultMap);
        return jsonObj;
    }

    @RequestMapping({"/register"})
    public JSONObject register(
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userPassword") String userPassword,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) throws Exception {
        logger.info("userEmail : {}", userEmail);
        logger.info("userPassword : {}", userPassword);
        logger.info("firstName : {}", firstName);
        logger.info("lastName : {}", lastName);


        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("userEmail", userEmail);
        paramMap.put("userPassword", userPassword);
        paramMap.put("firstName", firstName);
        paramMap.put("lastName", lastName);

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("data", "s");

        HashMap<String, Object> resultMap = accountService.findAccount(paramMap);

        if (resultMap != null) {
            // 이미 존재하는 회사명
            jsonObj.put("data", "d");
        } else {
            try {
                accountService.insertAccount(paramMap);
            } catch (Exception e) {
                jsonObj.put("data", "e");
            }
        }
        return jsonObj;
    }
}
