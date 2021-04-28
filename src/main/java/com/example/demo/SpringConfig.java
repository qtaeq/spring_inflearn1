package com.example.demo;

import com.example.demo.aop.TimeTraceAop;
import com.example.demo.repository.*;
import com.example.demo.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {
    
    // 자바코드로 스프링 빈 설정
    // memberController -> memberService -> memberRepository

    /*
    // JDBC
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource datasource){
        this.dataSource = datasource;
    }
    */
    /*
    // JPA
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository); // JPA Spring
        // return new MemberService(memberRepository());    // Else
    }

    /*
    @Bean
    public MemberRepository memberRepository(){


        return new JpaMemberRepository(em); //JPA
        // return new JdbcTemplateMemberRepository(dataSource); // JDBC Template
        //  return new JdbcMemberRepository(dataSource);    // 순수 JDBC
        //  return new MemoryMemberRepository();            // 메모리 JDBC
    }
     */
}
