package com.study.event.api.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// QueryDsl 세팅
@Configuration
public class QueryDslConfig {

    @PersistenceContext // 영속성을 제어하는 컨텍스트로 인식
    private EntityManager em;

    // <bean id='jpaQueryFactory' class='com.querydsl.jpa.impl.JPAQueryFactory'
    // class 는 리턴타입을 작성
    @Bean // 외부라이브러리를 스프링컨테이너에 관리시키는 설정
public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em); // 스프링이 대신 관리해준다
    }
}
