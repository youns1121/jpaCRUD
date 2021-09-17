package com.jpacrud.dto;

import com.jpacrud.domain.Category;
import com.jpacrud.domain.Member;
import com.jpacrud.enums.StatusEnums;
import com.querydsl.core.annotations.QueryProjection;
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
    private StatusEnums.Gender gender;

    @ApiModelProperty(value = "연락처")
    private String phone;

    @ApiModelProperty(hidden = true)
    private Member member;

    @ApiModelProperty(hidden = true)
    private Category category;

    @QueryProjection
    public MemberDto(Member member, Category category) {
        this.member = member;
        this.category = category;
    }









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
