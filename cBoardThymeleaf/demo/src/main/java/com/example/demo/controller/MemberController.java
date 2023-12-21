package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.domain.MemberVO;
import com.example.demo.service.MemberService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@RequestMapping("member")
@SessionAttributes("member") // Model에 "member" 이름으로 저장한 객체
public class MemberController {

    @Autowired
    public MemberService signupService;

    @RequestMapping("/{step}")
    public String viewPage(@PathVariable String step){
        return "/member/"+ step;
        // WEB-INF/views/ + board + xxxxxxxx + .jsp
    }

    @RequestMapping("/signup")
    public String signup(MemberVO vo) {
        System.out.println("Controller");
        signupService.insertMember(vo);
        return "redirect:/";
    }

    // ------------------------------------

    // 로그인
    @RequestMapping("login")
    public String login(MemberVO vo, Model m) {
        System.out.println("[[[ SignupController login() ]]] : " + vo);
        MemberVO result = signupService.login(vo);
        System.out.println("[result] : " + result);
        if(result != null) {
            m.addAttribute("member", result);
            return "member/loginSuccess";
            // return "redirect:loginSuccess"; // 뷰페이지 지정
        } else {
            // 여기서는 뷰페이지 지정이 가능하지만
            // 일부러 리다이렉트 상황을 만듬
            return "redirect:loginForm";
        }
    }
    /* 위에 예문은 일반적인 로그인 성공으로 세션처리 예제가 아닙니다.
     * 위에 예문은 Model(모델)에 데이터를 저장한 후 리다이렉트 되는 상황일 경우입니다.
     */
    
    



    
}
