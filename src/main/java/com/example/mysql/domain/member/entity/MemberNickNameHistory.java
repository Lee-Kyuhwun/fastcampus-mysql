package com.example.mysql.domain.member.entity;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter
public class MemberNickNameHistory {
    private final Long id;
    private final String nickname;
    private final LocalDateTime createdAt;


    final private Long memberid;

    @Builder
    public MemberNickNameHistory(Long id, String nickname, LocalDateTime createdAt, Long memberid) {
        this.id = id;
        this.nickname = Objects.requireNonNull(nickname);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
        this.memberid = Objects.requireNonNull(memberid);
    }
}
// 필드가 같다고 중복이 아인다.
// Member 엔티티에도 nickname이 있고 MemberNickNameHistory에도 nickname이 있다고 해서 중복인것이 아니다.
// 히스토리성 데이터는 정규화의 대상이 아니다. 히스토리성 데이터는 히스토리성 데이터로 관리해야한다.
// 정규화를 할 때 정규화의 대상이 항상 데이터의 최신성을 유지해야하는 건지 판단해야한다.