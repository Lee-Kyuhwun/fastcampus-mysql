package com.example.mysql.domain.member.repository;

import com.example.mysql.domain.member.entity.Member;
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
public class MemberRepository {

    static final private String TABLE = "member";
    public Optional<Member> findById(Long id){
        /*
         * select * from member where id =: id
         *
         * */
        String sql = String.format("select * from %s where id = :id",TABLE);
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("id",id);
        RowMapper<Member> rowMapper = (ResultSet resultSet, int rowNum) -> Member.builder()
                .id(resultSet.getLong("id"))
                .email(resultSet.getString("email"))
                .nickname(resultSet.getString("nickname"))
                .birthday(resultSet.getObject("birthday", LocalDate.class))
                .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
                .build();

        List<Member> member = namedParameterJdbcTemplate.query(sql, params, rowMapper);
        return member.isEmpty() ? Optional.empty() : Optional.of(member.get(0));
    }
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public Member save(Member member){
        /*
        * member의 아이디를 보고 갱신 또는 삽입을 정함
        * */
        if(member.getId()==null){
            return insert(member);
        }
        return update(member);
    }


    private Member insert(Member member){
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id")
                .usingColumns("nickname", "email", "birthday", "createdAt");
        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        var id= simpleJdbcInsert.executeAndReturnKey(params).longValue();

        return Member.builder().id(id).email(member.getEmail()).nickname(member.getNickname()).birthday(member.getBirthday()).build();
    }


    private Member update(Member member){

        //TODO: implement
        return member;
    }


}
