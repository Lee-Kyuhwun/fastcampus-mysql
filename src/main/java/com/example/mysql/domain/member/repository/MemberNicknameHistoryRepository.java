package com.example.mysql.domain.member.repository;

import com.example.mysql.domain.member.entity.Member;
import com.example.mysql.domain.member.entity.MemberNickNameHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberNicknameHistoryRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static final private String TABLE = "memberNicknameHistory";
    static final RowMapper<MemberNickNameHistory> rowMapper = (ResultSet resultSet, int rowNum) -> MemberNickNameHistory.builder()
            .id(resultSet.getLong("id"))
            .nickname(resultSet.getString("nickname"))
            .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
            .memberid(resultSet.getLong("memberId"))
            .build();

    public List<MemberNickNameHistory> findAllByMemberId(Long memberId){
        String sql = String.format("SELECT * FROM %s WHERE memberId = :memberId", TABLE);  // 수정된 부분
        MapSqlParameterSource param = new MapSqlParameterSource().addValue("memberId", memberId);
        return namedParameterJdbcTemplate.query(sql, param, rowMapper);
    }




    public MemberNickNameHistory save(MemberNickNameHistory member){
        /*
         * member의 아이디를 보고 갱신 또는 삽입을 정함
         * */
        if(member.getId()==null){
            return insert(member);
        }
        throw new UnsupportedOperationException("MemberNicknameHistoryRepository는 갱신을 지원하지 않습니다.");
    }


    private MemberNickNameHistory insert(MemberNickNameHistory history){
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id")
                .usingColumns("nickname", "memberId", "createdAt");
        SqlParameterSource params = new BeanPropertySqlParameterSource(history);
        var id= simpleJdbcInsert.executeAndReturnKey(params).longValue();

        return MemberNickNameHistory.builder()
                .id(id)
                .nickname(history.getNickname())
                .createdAt(history.getCreatedAt())
                .memberid(history.getMemberid())
                .build();
    }



}
