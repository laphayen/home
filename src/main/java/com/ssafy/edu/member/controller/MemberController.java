package com.ssafy.edu.member.controller;

import com.ssafy.edu.member.MemberDto;
import com.ssafy.edu.member.model.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 로그인 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/loginPage")
    public String login() {
        return "user/login"; // login.jsp로 이동
    }

    @PostMapping("/login")
    public String login(@RequestParam("userid") String userId, 
                        @RequestParam("userpwd") String userPwd, 
                        @RequestParam(value = "saveid", required = false) String saveId,
                        Model model, HttpServletResponse response, HttpSession session) {
        try {
            Map<String, String> loginParams = Map.of("userId", userId, "userPwd", userPwd);
            MemberDto member = memberService.loginMember(loginParams);

            if (member != null) {
                // 로그인 성공 시 세션에 사용자 정보 저장
                session.setAttribute("userinfo", member);
                model.addAttribute("member", member);

                // 아이디 저장 체크 여부 확인 후 쿠키 설정
                if ("ok".equals(saveId)) {
                    Cookie idCookie = new Cookie("ssafy_id", userId);
                    idCookie.setMaxAge(60 * 60 * 24 * 7); // 7일간 유지
                    response.addCookie(idCookie);
                } else {
                    Cookie idCookie = new Cookie("ssafy_id", null);
                    idCookie.setMaxAge(0); // 쿠키 삭제
                    response.addCookie(idCookie);
                }
                return "redirect:/"; // 로그인 성공 시 홈 페이지로 리다이렉트
            } else {
                model.addAttribute("loginFail", true); // 로그인 실패 표시
                return "index"; // 현재 페이지로 돌아가기
            }
        } catch (Exception e) {
            model.addAttribute("error", "오류가 발생했습니다: " + e.getMessage());
            return "/";
        }
    }


    // 회원가입 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/joinPage")
    public String join() {
        return "user/join"; // 회원가입 페이지로 이동
    }

    @PostMapping("/join")
    public String join(MemberDto memberDto, Model model) {
        try {
        	System.out.println("조인 컨트롤까지 오냐???");
        	System.out.println("컨트롤 까지 오는 memberDto" + memberDto);
            int result = memberService.joinMember(memberDto);
            System.out.println(result);
            if (result > 0) {
                return "redirect:/"; // 회원가입 성공 시 로그인 페이지로 리다이렉트
            } else {
                model.addAttribute("error", "회원가입에 실패했습니다.");
                return "user/join";
            }
        } catch (Exception e) {
            model.addAttribute("error", "오류가 발생했습니다: " + e.getMessage());
            return "user/join";
        }
    }
    
    // 로그아웃 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
    // 회원정보 수정 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/infoPage")
    public String info() {
        return "user/edit";
    }
    
    @PostMapping("/edit")
    public String edit(MemberDto memberDto, Model model, HttpSession session) {
    	System.out.println("Controller에서 회원정보 수정 memberDto 값" + memberDto);
        try {
            int result = memberService.editMember(memberDto);
            
            if (result > 0) {
                session.setAttribute("userinfo", memberDto);
                return "redirect:/user/infoPage";
            } else {
                model.addAttribute("error", "회원정보 수정에 실패했습니다.");
                return "user/edit";
            }
        } catch (Exception e) {
            model.addAttribute("error", "오류가 발생했습니다: " + e.getMessage());
            return "user/edit";
        }
    }
    
    // 회원 탈퇴 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // 회원 탈퇴
    @PostMapping("/delete")
    public String delete(HttpSession session, Model model) {
        MemberDto member = (MemberDto) session.getAttribute("userinfo");
        
        if (member != null) {
            try {
                int result = memberService.deleteMember(member.getUserId());
                if (result > 0) {
                    session.invalidate(); // 탈퇴 후 세션 종료
                    return "redirect:/"; // 홈 페이지로 리다이렉트
                } else {
                    model.addAttribute("error", "회원 탈퇴에 실패했습니다.");
                    return "user/edit";
                }
            } catch (Exception e) {
                model.addAttribute("error", "오류가 발생했습니다: " + e.getMessage());
                return "user/edit";
            }
        } else {
            model.addAttribute("error", "세션 정보가 없습니다.");
            return "user/login";
        }
    }

    
    
}
