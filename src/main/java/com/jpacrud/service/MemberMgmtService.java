package com.jpacrud.service;

import com.jpacrud.domain.Member;
import com.jpacrud.dto.MemberDto;
import com.jpacrud.mapper.MemberMapperImpl;
import com.jpacrud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.jpacrud.enums.StatusEnums.UserRole.USER_NONE;

@RequiredArgsConstructor
@Service
public class MemberMgmtService {

    private final MemberRepository memberRepository;


    @Transactional
    public Long createMember(MemberDto memberDto) {


        Member member = new Member();

        member.createUser(memberDto);

//        MemberMapperImpl.INSTANCE.memberDtoToMember(memberDto); // Dto -> Entity 변환


        return memberRepository.save(member).getSeq();


    }

}
