package com.example.demo;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @RequestMapping("/home")
    public String home(Model m) {

        m.addAttribute("userId", "홍길동");
        m.addAttribute("serverTime", new Date().toString());



        // ***********************************
        return "home"; // 뷰페이지  
        /*
         * Spring : /WEB-INF/views + home + .jsp
         * SpringBoot (기본값) : resources / templates + home + .html
         */
    }
}
