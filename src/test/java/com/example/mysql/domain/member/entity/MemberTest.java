package com.example.mysql.domain.member.entity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {


    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangName(){
        //given
        Member member = Member.builder()
                .nickname("test")
                .email()
                // object Mother pattern
                .build();
    }
}