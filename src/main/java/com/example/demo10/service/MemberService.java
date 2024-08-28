package com.example.demo10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo10.dto.MemberDto;
import com.example.demo10.mapper.MemberMapper;

@Service
public class MemberService {

    @Autowired
    MemberMapper mapper;

    public MemberDto login(MemberDto member) {
        return mapper.login(member);
    }

    public int insertMember(MemberDto member) {
        return mapper.insertMember(member);
    }

    public int selectCheckId(String id) {
        return mapper.selectCheckId(id);
    }

}
