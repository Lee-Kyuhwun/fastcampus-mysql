package com.example.mysql.domain.member.service;


import com.example.mysql.domain.member.dto.RegisterMemberCommend;
import com.example.mysql.domain.member.entity.Member;
import com.example.mysql.domain.member.entity.MemberNickNameHistory;
import com.example.mysql.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.mysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberWriteService {

    private final MemberNicknameHistoryRepository memberNicknameHistoryRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Member create(RegisterMemberCommend commend){
        var member = Member.builder()
                .nickname(commend.nickname())
                .email(commend.email())
                .birthday(commend.birthdate())
                .build();
        Member savedMember = memberRepository.save(member);
        var zero = 0/0;
        saveMemberNicknameHistory(savedMember);
        return savedMember;
    }

    //

    public void changeNickName(Long memberId, String nickname){
        /*
        * 목표 - 회원의 닉네임을 변경
        * 파라미터 - memberId, nickname
        * val member = memberRepository.findById(memberId)
        * member.changeNickname(nickname)
        * memberRepository.save(member)
        * */
        Member member = memberRepository.findById(memberId).orElseThrow();
        member.changeNickname(nickname);
        memberRepository.save(member);
        saveMemberNicknameHistory(member);
    }

    private void saveMemberNicknameHistory(Member member) {
        MemberNickNameHistory history = MemberNickNameHistory.builder()
                .memberid(member.getId())
                .nickname(member.getNickname())
                .build();
        memberNicknameHistoryRepository.save(history);
    }


}
