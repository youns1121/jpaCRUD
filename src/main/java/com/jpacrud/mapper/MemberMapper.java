package com.jpacrud.mapper;

import com.jpacrud.domain.Member;
import com.jpacrud.dto.MemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

 //unmappedTargetPolicy = ReportingPolicy.IGNORE : 일치하지 않는 필드 무시
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {


    /**
     * Entity와 Dto 필드가 다를경우 수동으로 매핑 해야 함
     */


    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);



    Member memberDtoToMember(MemberDto memberDto);

    MemberDto memberToMemberDto(Member member);
}











