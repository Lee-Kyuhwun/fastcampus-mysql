package com.example.mysql.domain.member.service;


import com.example.mysql.domain.member.dto.RegisterMemberCommend;
import com.example.mysql.domain.member.entity.Member;
import com.example.mysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class MemberWriteService {


    private final MemberRepository memberRepository;
    public Member create(RegisterMemberCommend commend){
        /*
        * 목표 - 회원 정보(이름, 닉네임, 생년월일)를 등록
        *     - 닉네임을 10자를 넘길 수 없다.
        * 파라미터 - memberRegisterCommend
        * val member =Member.of(memberRegisterCommend)
        *  memberRepository.save(member)
        * */

        var member = Member.builder()
                .nickname(commend.nickname())
                .email(commend.email())
                .birthday(commend.birthdate())
                .build();
        return memberRepository.save(member);
    }

}
