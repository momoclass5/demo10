package com.example.demo10.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo10.dto.MemberDto;
import com.example.demo10.dto.SelectDto;

@SpringBootTest
public class MemberMapperTest {

    @Autowired
    MemberMapper mapper;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Test
    void testLogin() {
        MemberDto member = new MemberDto();
        member.setId("USER01");
        member.setPw("USER01");
        MemberDto loginMember = mapper.login(member);
        assertNotNull(loginMember);
    }

    @Test
    void testLogin1() {
        MemberDto member = new MemberDto();
        member.setId("USER");
        member.setPw("USER");
        MemberDto loginMember = mapper.login(member);
        assertNull(loginMember);
    }

    @Test
    void testSelectCheckId() {
        int res = mapper.selectCheckId("USER01");
        assertEquals(1, res);
    }

    @Test
    void testUpdatepw() {
        // 아이디로 비밀번호를 조회
        MemberDto member = new MemberDto();
        member.setId("id");

        // 원래 비밀번호를 조회
        MemberDto loginMember = mapper.login(member);

        // 암호화된 비밀번호 입력
        String encodePw = encoder.encode(loginMember.getPw());
        loginMember.setPw(encodePw);

        int res = mapper.updatePw(loginMember);

        assertEquals(1, res);
    }

    @Test
    void testSelectMemberList() {
        List<MemberDto> list = mapper.selectMemberList(new SelectDto());
        assertEquals(10, list.size());
    }
}
