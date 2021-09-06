package com.jpacrud.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListRequestDto {


    @ApiModelProperty(value = "카테고리 이름")
    private String categoryName;


}
