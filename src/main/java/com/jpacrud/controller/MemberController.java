package com.jpacrud.controller;


import com.jpacrud.domain.Member;
import com.jpacrud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/index")
public class MemberController {


    @Autowired
    MemberRepository memberRepository;


    @PostMapping("/create") // 생성, CREATE
    public String create(@RequestBody Member member) {

        Member memberSave = memberRepository.save(member);

        return member.getMemberName() + "님 회원가입을 축하드립니다~!";
    }

    public String findMember() {
        return null;
    }

    @GetMapping("/read") //조회, READ
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
