package com.example.mysql.domain.member.entity;

import com.example.mysql.domain.member.dto.RegisterMemberCommend;
import io.swagger.v3.core.util.OpenAPISchema2JsonSchema;
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


    private void validNickname(String nickname){
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과했습니다.");
    }

   // 엔티티의 데이터들은 객체 안에서만 관리되어야한다. 나중에 변경할때 쉬어진다.


    public void changeNickname(String to){
        Objects.requireNonNull(to);
//        validNickname(to);
        this.nickname = to;
    } // 이렇게 객체안에 넣으면 단위테스트에 유리해진다. 객체안에서만 관리되기 때문에



}
