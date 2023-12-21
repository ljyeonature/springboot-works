package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.domain.SignupDTO;
import com.example.demo.service.SignupService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("signup")
public class SignupController {

    @Autowired
    public SignupService signupService;


    @RequestMapping("/registForm")
    public void signForm() {

    }
    

    @RequestMapping("/signup")
    public String signup(SignupDTO dto) {
        System.out.println("Controller");
        signupService.insertMember(dto);
        return "signup/regist";
    }
    



    
}
