package com.jpacrud.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpacrud.domain.Member;
import com.jpacrud.domain.Team;
import com.jpacrud.dto.MemberDto;
import com.jpacrud.repository.MemberRepository;
import com.jpacrud.repository.TeamRepository;
import com.jpacrud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/index")
public class MemberController {


    @Autowired
    MemberRepository memberRepository;



    @JsonIgnore
    @PostMapping("/create") // 멤버 생성, CREATE
    public String create(@RequestBody Member member) {

        memberRepository.save(member);

        return member.getMemberName() + "님 회원가입을 축하드립니다~!";
    }






    @GetMapping("/read") //조회, READ, Member
    public Member read(@RequestParam Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);

        return member.get();
    }






    @PutMapping("/update") //변경, UPDATE
    public Optional<Member> update(@RequestParam Long memberId, @RequestBody Member member) {

        Optional<Member> updateMember = memberRepository.findById(memberId);

        updateMember.ifPresent(selectMember -> {

            selectMember.setMemberName(member.getMemberName());
            selectMember.setMemberAccount(member.getMemberAccount());
            selectMember.setMemberPassword(member.getMemberPassword());

            memberRepository.save(selectMember);
        });
        return updateMember;

    }

    @DeleteMapping("/delete") // 삭제, DELETE
    public Member delete(@RequestParam Long memberId) {


        Optional<Member> memberDelete = memberRepository.findById(memberId);

        memberDelete.ifPresent(selectMember -> {
            memberRepository.delete(selectMember);
        });

        return memberDelete.get();
    }






}
