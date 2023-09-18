package com.example.mysql.domain.member.service;


import com.example.mysql.domain.member.dto.MemberDto;
import com.example.mysql.domain.member.dto.MemberNicknameHistoryDto;
import com.example.mysql.domain.member.entity.Member;
import com.example.mysql.domain.member.entity.MemberNickNameHistory;
import com.example.mysql.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.mysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberReadService {

    private final MemberRepository memberRepository;
    private final MemberNicknameHistoryRepository memberNicknameHistoryRepository;

    public List<MemberNicknameHistoryDto> getNickNameHistories(Long memberId){
        return memberNicknameHistoryRepository.findAllByMemberId(memberId).stream().map(history -> toDto(history)).toList();
    }


    public MemberDto getMember(Long id){


        Member member = memberRepository.findById(id).orElseThrow();
        return toDto(member);
    }

    public List<MemberDto> getMembers(List<Long> memberIds) {
        var members = memberRepository.findAllByIdIn(memberIds);
        return members.stream()
                .map(this::toDto)
                .toList();
    }


    public MemberDto toDto(Member member){
        return new MemberDto(member.getId(), member.getEmail(), member.getNickname(), member.getBirthday());
    }

    private MemberNicknameHistoryDto toDto(MemberNickNameHistory history){
        return new MemberNicknameHistoryDto(history.getId(), history.getNickname(),history.getMemberid(), history.getCreatedAt());
    }
}
