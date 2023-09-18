package com.example.mysql.controller;


import com.example.mysql.domain.member.dto.MemberDto;
import com.example.mysql.domain.member.dto.MemberNicknameHistoryDto;
import com.example.mysql.domain.member.dto.RegisterMemberCommend;
import com.example.mysql.domain.member.entity.Member;
import com.example.mysql.domain.member.service.MemberReadService;
import com.example.mysql.domain.member.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class MemberController {

    private  final  MemberWriteService memberWriteService;

    private final MemberReadService memberReadService;


    @PostMapping("/members")
    public MemberDto register(@RequestBody RegisterMemberCommend commend){
       Member member = memberWriteService.create(commend);
       return memberReadService.toDto(member);
    }


    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable Long id) {
        return memberReadService.getMember(id);
    }


    @PutMapping("/members/{id}/nickname")
    public MemberDto changeNickname(@PathVariable Long id, @RequestBody String nickname){
        memberWriteService.changeNickName(id, nickname);
        return memberReadService.getMember(id);
    }

    @GetMapping("/{memberId}/nickname-histories")
    public List<MemberNicknameHistoryDto> getNickNameHistories(@PathVariable Long memberId){
        return memberReadService.getNickNameHistories(memberId);
    }
}
