package com.jpacrud.service;

import com.jpacrud.domain.Member;
import com.jpacrud.domain.Team;
import com.jpacrud.repository.MemberRepository;
import com.jpacrud.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;


    public void save(Member member, Team team) {

        member.setTeam(team);

        memberRepository.save(member);

    }
}

