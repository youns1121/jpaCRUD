package com.jpacrud.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListRequestDto {


    @ApiModelProperty(value = "카테고리 이름")
    private String categoryName;

    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "삭제여부")
    private String delYn;



}
