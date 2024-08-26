package com.example.demo10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class CookieController {
    @GetMapping("/cookie")
    public String getMethodName(HttpServletRequest request, HttpServletResponse response) {
        // // 쿠키생성
        // // 쿠키는 key, value로 생성되어짐
        // Cookie cookie = new Cookie("saveId", "abcd");
        // cookie.setPath("/");
        // // 3600초
        // cookie.setMaxAge(60 * 60);

        // response.addCookie(cookie);
        return "cookie";
    }

    @GetMapping("/loginAction")
    public String getMethodName(@RequestParam(name = "chkIdSave", required = false) String chkIdSave,
            @RequestParam(name = "userId") String userId,
            HttpServletResponse response) {

        System.out.println("chkIdSave : " + chkIdSave);
        log.info("userId : " + userId);
        // 체크박스가 체크 된 경우
        Cookie cookie = new Cookie("saveId", userId);
        cookie.setPath("/");
        // 3600초
        if (chkIdSave != null && chkIdSave.equals("1")) {
            // if("1".equals(chkSaveId)){
            cookie.setMaxAge(60 * 60);
        } else {
            // 쿠키 제거
            // 만료시간을 0으로 만들어줍니다
            // if("1".equals(chkSaveId)){
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
        return "cookie";
    }

}
