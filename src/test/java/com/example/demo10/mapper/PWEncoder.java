package com.example.demo10.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo10.dto.MemberDto;

/**
 * 비밀번호 암호화
 * spring-security-core 라이브러리를 추가후 사용가능
 * 
 * BCryptPasswordEncoder 객체를 사용하여 암호화 처리
 * ✨ 암호화 적용후 비밀번호의 길이가 길어지게 되어 오류가 발생 할 수 있다!!!!!
 * -> 컬럼의 길이를 늘려서 오류가 발생하지 않도록 하는 처리가 필요!!!!!!!
 * 
 */
@SpringBootTest
public class PWEncoder {
    // 라이브러리 추가후 사용 가능
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    MemberMapper mapper;

    /**
     * 암호화 테스트
     */
    @Test
    public void test() {
        MemberDto member = new MemberDto();
        member.setId("id1234");
        member.setName("name");

        String pw = "pw";
        // 비밀번호를 암호화 해서 변수에 저장
        String encodePw = encoder.encode(pw);

        // 암호화된 비밀번호를 dto객체의 pw에 저장
        member.setPw(encodePw);

        int res = mapper.insertMember(member);
        assertEquals(1, res);

    }

    /*
     * 암호화된 값 확인
     */
    @Test
    public void test2() {
        String pw = "pw";
        // 비밀번호를 암호화 해서 변수에 저장
        String encodePw = encoder.encode(pw);

        // 암호화된값과 일치 하는지 확인하는 함수
        boolean res = encoder.matches(pw, encodePw);

        assertEquals(true, res);
    }

}
