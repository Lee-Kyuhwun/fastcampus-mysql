package com.example.mysql.domain.follow.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Follow {
    private final Long id;

    private final Long fromMemberId;
    private final Long toMemberId;

    private final LocalDateTime createdAt;

    @Builder
    public Follow(Long id, Long fromMemberId, Long toMemberId, LocalDateTime createdAt) {
        this.id = id;
        this.fromMemberId = Objects.requireNonNull(fromMemberId);
        this.toMemberId = Objects.requireNonNull(toMemberId);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    } // 계속 이부분 중복되는데 createdAt 이거 어떻게 추상화가 가능할지 고민

} // follow는 결국 2명의 회원에 대한 정보를 가지고있어야한느데 그럴때 네이밍에 대해서 생각해봐야한다.