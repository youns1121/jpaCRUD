package com.jpacrud.repository;

import com.jpacrud.domain.Member;


import com.jpacrud.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@SpringBootTest //Junit 에 필요한 어노테이션
@WebAppConfiguration
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;


    /**
     * JPA_CRUD_V2 : @ManyToOne,
     */

    @Test
    public void create(){ //생성

        Team team = new Team();
        team.setTeamName("레드팀");
        team.setTeamAddress("배곧");
        teamRepository.save(team);

        Member member = new Member();
        member.setMemberAccount("V2_TEST2");
        member.setMemberPassword("121111");
        member.setMemberName("min");
        member.setTeam(team);

        memberRepository.save(member);
    }


    @Test
    @Transactional
    public void memberRead(){ //조회
        Optional<Member> readMember = memberRepository.findById(1L);
        Optional<Team> readTeam = teamRepository.findById(1L);


        readMember.ifPresent(selectMember ->{

            System.out.println(selectMember.getMemberAccount());
            System.out.println(selectMember.getMemberName());
            System.out.println(selectMember.getMemberPassword());
            System.out.println(selectMember.getTeam());
        });


        readTeam.ifPresent(selectTeam ->{

            System.out.println(selectTeam.getTeamName());
            System.out.println(selectTeam.getTeamAddress());
            System.out.println(selectTeam.getMembers());
        });

    }

    @Test
    @Transactional
    public void teamRead(){ //조회
        Optional<Team> readTeam = teamRepository.findById(1L);

        readTeam.ifPresent(selectTeam ->{
            System.out.println(selectTeam.getMembers());
            System.out.println(selectTeam.getTeamName());
            System.out.println(selectTeam.getTeamAddress());
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