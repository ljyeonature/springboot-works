package com.example.demo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.domain.FileVO;
import com.example.demo.domain.MemberVO;
import com.example.demo.service.MemberService;
import com.example.demo.util.MD5Generator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;



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
    public String signup(@RequestParam("file") MultipartFile file, MemberVO vo) {
        // System.out.println("Controller");
        String originFilename = file.getOriginalFilename();
        System.out.println("originFilename: " + originFilename);
        if(originFilename != null && !originFilename.equals("")) {
            // 파일첨부가 있는 경우
            try {
                String filename = new MD5Generator(originFilename).toString();

                // 생성되는 폴더의 위치를 확인 후 추후 변경
                // -> static 폴더 밑으로 이동해야 사용자가 그 파일을 접근 가능
                String savePath = System.getProperty("user.dir") + "\\files";
                if (!new File(savePath).exists()) {
                    new File(savePath).mkdir();
                }
                String filepath = savePath + "\\" + filename;

                System.out.println("filepath:" + filepath);

                // 업로드한 파일 =>  경로에 업로딩 = 파일저장
                file.transferTo(new File(filepath));

                // DB저장
                FileVO fvo = new FileVO();
                fvo.setOriginFilename(originFilename);
                fvo.setFilename(filename);
                fvo.setFilepath(filepath);
                // 첨부된 파일이 있으므로 fvo를 넣어준다.
                signupService.insertMember(vo, fvo);

                }catch (Exception ex) {
                        System.out.println("파일업로드 실패:" + ex.getMessage());
                }
        }else {
            // 파일첨부가 없는 경우
            signupService.insertMember(vo, null);
        }
        return "redirect:mypage";
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

    @RequestMapping("mypage")
    public String mypage(@PathVariable String name, Model m) {
        MemberVO mvo = new MemberVO();
        mvo.setName(name);
        String result = signupService.selectSrc(mvo.getName());
        System.out.println(result);
        m.addAttribute("src", result);
        System.out.println("/member/mypage?name=" + mvo.getName());
        return "/member/mypage?name=" + mvo.getName(); 
    }
    
    



    
}
