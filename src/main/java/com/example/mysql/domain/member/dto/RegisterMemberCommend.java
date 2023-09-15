package com.example.mysql.domain.member.dto;

import java.time.LocalDate;

public record RegisterMemberCommend(
        String email,
        String nickname,
        LocalDate birthdate
) {


}
