package com.example.demo10.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo10.dto.MemberDto;
import com.example.demo10.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class memberController {

    @Autowired
    MemberService service;

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String getMethodName() {
        return "/login";
    }

    // 기본적으로 url이 동일하면 오류가 발생
    // 요청방식 다르다면 url이 같아도 됨
    @PostMapping("/login")
    public String getMethodName1() {
        // 로그인 액션 처리
        return "/login";
    }

    @GetMapping("/loginA")
    public String getMethodNamea(HttpServletResponse response) {
        Cookie cookie = new Cookie("userSession", "someSessionId");
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60); // 1 hour
        response.addCookie(cookie);
        return "/member/login";
    }

    @GetMapping("/getCookie")
    @ResponseBody
    public String getCookie(@RequestParam(name = "cookieName", defaultValue = "userSession") String cookieName,
            @CookieValue(value = "userSession", defaultValue = "not found") String cookieValue) {
        return "Cookie value: " + cookieValue;
    }

    // 로그인 페이지로 이동
    @GetMapping("/register")
    public String register() {
        return "/member/register";
    }

    // 로그인 처리
    // 아이디 저장하기
    // 체크박스가 체크되어 있으면 아이디를 쿠키에 저장 할수 있도록 처리
    @PostMapping("/loginAction")
    public String postMethodName(MemberDto member, @RequestParam(name = "chkIdSave", required = false) String chkIdSave,
            HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) {

        log.info("id : " + member.getId());
        log.info("pw : " + member.getPw());
        log.info("chkIdSave : " + chkIdSave);

        Cookie cookie = new Cookie("IdSave", member.getId());
        cookie.setPath("/");
        // 체크박스가 선택되어 있다면 아이디를 쿠키에 저장
        if ("1".equals(chkIdSave)) {
            // 쿠키 생성
            // 로그인을 할때마다 쿠키의 유효기간을 늘려준다!
            cookie.setMaxAge(60 * 60 * 24 * 7);
        } else {
            // 쿠키 제거
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
        // member/loginAction
        log.info("/member/loginAction");

        // 아이디 비밀번호를 수집하고
        // 로그인성공이면 메인페이지로 이동
        // 로그인 성공이면 - 도서목록(/)
        MemberDto loginMember = service.login(member);
        if (loginMember != null) {
            session.setAttribute("loginId", loginMember.getId());
            session.setAttribute("loginName", loginMember.getName());
            return "/";
        }
        // 실패이면 로그인페이지로 이동
        // 템플릿 경로에 있는 html문서를 보여줌
        // 로그인 실패이면 - 다시 로그인 페이지로 가서 메세지를 화면에 출력
        model.addAttribute("msg", "아이디 비밀번호를 확인해주세요");
        return "/login";

    }

}
