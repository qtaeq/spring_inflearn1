package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTests {
    
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join(){
        //given
        Member member = new Member();
        member.setName("SpringTest");

        //when
        Long saveId = memberService.join(member);
        
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("SpringTest");

        Member member2 = new Member();
        member2.setName("SpringTest");


        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
           () -> memberService.join(member2));//예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        // 아래 try-catch문이 위 When과 동일한 기능이다.
        try{
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123");
        }
        */
        

        //then
    }

    @Test
    void findMembers(){

    }

    @Test
    void findOne(){

    }
}
