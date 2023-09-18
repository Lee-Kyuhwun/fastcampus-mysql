package com.example.mysql.domain.member.entity;

import com.example.mysql.domain.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {


    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangName(){
        Member member = MemberFixtureFactory.create();
        String expected = "pnu";
        member.changeNickname(expected);

        Assertions.assertEquals(expected, member.getNickname());
    }

    @DisplayName("회원은 닉네임은 10자를 초과할 수 없다.")
    @Test
    public void testNickNameMaxLength(){
        Member member = MemberFixtureFactory.create();
        String expected = "12345678901111111";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            member.changeNickname(expected);
        });
    }
}