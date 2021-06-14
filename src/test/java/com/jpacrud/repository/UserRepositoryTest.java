package com.jpacrud.repository;

import com.jpacrud.domain.Member;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;


@SpringBootTest //Junit 에 필요한 어노테이션
@WebAppConfiguration
class UserRepositoryTest{

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Test
    public void create(){ //생성

        Member member = new Member();

        member.setMemberAccount("ysmin1234");
        member.setMemberPassword("1234");
        member.setMemberName("ysmin");


        Member saveMember = memberRepository.save(member);
    }


    @Test
    public void read(){ //검색
        Optional<Member> readMember = memberRepository.findById(1L);

        readMember.ifPresent(selectMember ->{
            System.out.println(selectMember.getMemberName());
            System.out.println(selectMember.getMemberPassword());
        });
    }


    @Test
    public void update(){ // 수정
        Optional<Member> member = memberRepository.findById(1L);

        member.ifPresent(selectMember->{

            selectMember.setMemberPassword("1q2w3e4r");
            selectMember.setMemberAccount("test999");
            selectMember.setMemberName("민연식");

            memberRepository.save(selectMember);

        });
    }


    @Test
    public void delete(){
        Optional<Member> member = memberRepository.findById(2L);


        member.ifPresent(selectMember ->{
            memberRepository.delete(selectMember);

        });


    }

}