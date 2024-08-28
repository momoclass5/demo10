package com.example.demo10.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo10.dto.MemberDto;

@SpringBootTest
public class MemberMapperTest {

    @Autowired
    MemberMapper mapper;

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
}
