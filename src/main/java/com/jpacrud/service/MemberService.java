package com.jpacrud.service;

import com.jpacrud.domain.Member;
import com.jpacrud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

//    public void save(Member member){
//        memberRepository.save(member);

    }

