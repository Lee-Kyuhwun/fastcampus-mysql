package com.example.mysql.domain.util;

import com.example.mysql.domain.member.entity.Member;

public class MemberFixtureFactory {
    static public Member create(){
        return Member.builder().build();
    }
}
