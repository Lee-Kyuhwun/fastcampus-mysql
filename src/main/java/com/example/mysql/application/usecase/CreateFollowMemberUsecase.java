package com.example.mysql.application.usecase;


import com.example.mysql.domain.follow.service.FollowWriteService;
import com.example.mysql.domain.member.dto.MemberDto;
import com.example.mysql.domain.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
// 두 도메인 간의 orchestration을 담당하는 usecase
public class CreateFollowMemberUsecase {
    private final MemberReadService memberReadService;
    private final FollowWriteService followWriteService;
    public void execute(Long fromMemberId, Long toMemberId){
        /*
        *  1. 입력받은 memberId로 회원조회
        * 2. FollowWrtieService.create(fromMember, toMember)
        */
        MemberDto members = memberReadService.getMember(fromMemberId);
        MemberDto toMember = memberReadService.getMember(toMemberId);

        followWriteService.create(members, toMember);
    }
}
// 유즈케이스 레이어는 가능한 로직이 없어야한다.
// 유즈케이스 레이어는 도메인 레이어의 서비스의 흐름만 제어하는 역할만 한다.


