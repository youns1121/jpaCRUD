package com.jpacrud.repository;

import com.jpacrud.JpaCrudApplication;
import com.jpacrud.domain.Member;
import com.jpacrud.domain.Team;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest
@WebAppConfiguration
class UserRepositoryTest extends JpaCrudApplication{

    @Autowired
     MemberRepository memberRepository;

    @Test
    public void select(){



        Member member = new Member();

        member.setMemberName("ysmin");
        member.setMeberPassword("1234");

        Member saveMember = memberRepository.save(member);



    }

}