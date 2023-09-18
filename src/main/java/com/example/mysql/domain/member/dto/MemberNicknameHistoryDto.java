package com.example.mysql.domain.member.dto;

import java.time.LocalDateTime;

public record MemberNicknameHistoryDto(
        Long id,
        String nickname,
        Long memberId,
        LocalDateTime createdAt

) {
}
