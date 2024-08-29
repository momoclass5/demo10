package com.example.demo10.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo10.dto.MemberDto;
import com.example.demo10.dto.SelectDto;

@Mapper
public interface MemberMapper {

    MemberDto login(MemberDto member);

    int insertMember(MemberDto member);

    int selectCheckId(String id);

    int updatePw(MemberDto member);

    List<MemberDto> selectMemberList(SelectDto selectDto);

    int selectTotalCnt();

}
