package com.jpacrud.dto;

import com.jpacrud.domain.Member;
import com.jpacrud.enums.StatusEnums;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    @ApiModelProperty(value = "카테고리 이름")
    private String categoryName;

    @ApiModelProperty(value = "카테고리 설명")
    private String categoryComment;

    @ApiModelProperty(value = "회원 아이디")
    private String memberId;

    @ApiModelProperty(hidden = true)
    private Member member;

    @ApiModelProperty(hidden = true)
    private StatusEnums.UserRole userRole;


}
