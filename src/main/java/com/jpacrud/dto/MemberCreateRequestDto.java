package com.jpacrud.dto;

import com.jpacrud.domain.MemberStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MemberCreateRequestDto {

    private String memberName;

    private MemberStatus status;

}
