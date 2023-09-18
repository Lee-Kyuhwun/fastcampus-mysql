package com.example.mysql.controller;


import com.example.mysql.domain.member.dto.MemberDto;
import com.example.mysql.domain.member.dto.RegisterMemberCommend;
import com.example.mysql.domain.member.entity.Member;
import com.example.mysql.domain.member.repository.MemberRepository;
import com.example.mysql.domain.member.service.MemberReadService;
import com.example.mysql.domain.member.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.sql.ResultSet;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class MemberController {

    private  final  MemberWriteService memberWriteService;

    private final MemberReadService memberReadService;


    @PostMapping("/members")
    public MemberDto register(@RequestBody RegisterMemberCommend commend){
       Member member = memberWriteService.register(commend);
       return memberReadService.toDto(member);
    }


    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable Long id) {
        return memberReadService.getMember(id);
    }
}