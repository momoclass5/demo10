package com.example.demo10.controller;

import java.net.http.HttpResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo10.dto.MemberDto;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class memberController {

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String getMethodName() {
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
    @PostMapping("/loginAction")
    public String postMethodName(MemberDto member) {

        log.info("id : " + member.getId());
        log.info("pw : " + member.getPw());
        // member/loginAction
        log.info("/member/loginAction");
        // 아이디 비밀번호를 수집하고
        // 로그인성공이면 메인페이지로 이동
        // 실패이면 로그인페이지로 이동
        return "/member/login";
    }

}
