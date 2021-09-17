package com.jpacrud.service;

import com.jpacrud.config.auth.SecurityMember;
import com.jpacrud.domain.Member;
import com.jpacrud.dto.MemberDto;

import com.jpacrud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberMgmtService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Transactional
    public Long createMember(MemberDto memberDto) {


        Member member = new Member();

        member.createUser(memberDto);

//        MemberMapperImpl.INSTANCE.memberDtoToMember(memberDto); // Dto -> Entity 변환


        return memberRepository.save(member).getSeq();


    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        Member member = memberRepository.findByMemberId(memberId);

        if(member == null){
            return null;
        }
        else
            return new SecurityMember(member);
    }
}
