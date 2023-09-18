package com.example.mysql.domain.util;

import com.example.mysql.domain.member.entity.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;


/**
 * 테스트 또는 픽스처 목적으로 Member 인스턴스를 생성하는 팩토리 클래스입니다.
 * EasyRandom 라이브러리를 활용하여 시드 값을 기반으로 무작위 Member 인스턴스를 생성합니다.
 */
public class MemberFixtureFactory {


    static public Member create(){
        EasyRandomParameters param =  new EasyRandomParameters();
        return new EasyRandom(param).nextObject(Member.class);
    }

    /**
     * 주어진 시드 값에 기반하여 EasyRandom 라이브러리를 사용해 무작위 Member 인스턴스를 생성합니다.
     *
     * @param seed 무작위 생성을 위한 기본 시드 값
     * @return 시드 값에 기반한 무작위로 생성된 Member 객체
     */
    static public Member create(Long seed) {
        // EasyRandom의 파라미터 설정입니다. 주어진 시드 값을 사용하여 생성됩니다.
        EasyRandomParameters param = new EasyRandomParameters().seed(seed);

        // Member 클래스의 새로운 무작위 인스턴스를 반환합니다.
        return new EasyRandom(param).nextObject(Member.class);
    }
}
