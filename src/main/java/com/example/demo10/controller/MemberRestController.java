package com.example.demo10.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MemberRestController {
    @GetMapping("checkId")
    public Map<String, Integer> getMethodName(@RequestParam(name = "id", required = false) String param) {

        Map<String, Integer> map = new HashMap<>();
        map.put("res", 0);
        return map;
    }

}
