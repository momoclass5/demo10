package com.example.demo10.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo10.dto.MemberDto;

@Mapper
public interface MemberMapper {

    MemberDto login(MemberDto member);

    int insertMember(MemberDto member);

    int selectCheckId(String id);

}
