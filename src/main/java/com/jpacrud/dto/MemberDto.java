package com.jpacrud.dto;

import com.jpacrud.domain.Member;
import com.jpacrud.enums.StatusEnums;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberDto {

    @ApiModelProperty(value = "아이디")
    private String memberId;

    @ApiModelProperty(value = "비밀번호")
    private String password;

    @ApiModelProperty(value = "이름")
    private String name;

    @ApiModelProperty(value = "나이")
    private String age;

    @ApiModelProperty(value = "이메일")
    private String email;

    @ApiModelProperty(value = "성별")
    private String gender;

    @ApiModelProperty(value = "연락처")
    private String phone;

    @ApiModelProperty(value = "사용자권한")
    private StatusEnums.UserRole userRole;


    @ApiModelProperty(hidden = true)
    private Member member;




    /**
     * 요청은 toEntity
     * 응답은 of
     *
     * -> Entity -> Dto
     *
     * https://huisam.tistory.com/entry/mapStruct
     */

    public static MemberDto toEntity(Member member){

        return builder()
                .memberId(member.getMemberId())
                .build();


    }

}
