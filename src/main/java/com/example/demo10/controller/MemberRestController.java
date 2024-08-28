package com.example.demo10.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo10.dto.MemberDto;
import com.example.demo10.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.HashMap;

/**
 * JSON형식의 문자열을 전달 하는 방식
 * 반환하는 객체를 JSON형식의 문자열로 변환 하여 클라이언트에게 전달
 */
@RestController
public class MemberRestController {

    @Autowired
    MemberService service;

    /**
     * PATH를 이용하여 파라메터를 전달하는 방식을 이용할 수 있다
     */
    @GetMapping("/checkId/{id}")
    public Map<String, Object> getMethodName(@PathVariable(name = "id") String id) {
        Map<String, Object> map = new HashMap<>();

        int res = service.selectCheckId(id);

        map.put("res", res);
        // MemberDto member = new MemberDto();
        // member.setId(id);
        // map.put("member", member);
        // Map형식으로 반환
        return map;
    }

}
