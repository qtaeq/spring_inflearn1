package com.example.demo.repository;
import com.example.demo.domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach      // 각 테스트 끝나고 항상 해당 함수 실행
    public void afterEach(){
        repository.clearStore();
    }


    @Test           // 각 테스트는 서로에게 의존관계가 없어야 하며
                    // 테스트 케이스는 함수별로 개별로 실행됨
    public void save() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        repository.save(member);
        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring1").get();

        System.out.println(result.getName() + " " + result.getId());

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
        public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring3");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring4");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }


}