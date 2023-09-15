package com.example.mysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter
public class Member {
    @Builder
    public Member(Long id, String nickname, String email, LocalDate birthday, LocalDateTime createdAt) {
        validNickname(nickname);

        this.id = id;
        this.email = Objects.requireNonNull(email);
        this.nickname   = Objects.requireNonNull(nickname);
        this.birthday   = Objects.requireNonNull(birthday);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    final private Long id;

    private String nickname;

    final private String email;

    final private LocalDate birthday;

    final private LocalDateTime createdAt;

    final  private Long NAME_MAX_LENGTH = 10L;


    void validNickname(String nickname){
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과했습니다.");
    }

}
