package com.jpacrud.dto.request;

import com.jpacrud.enums.Mapper.EnumMapperValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListRequestDto {




    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "삭제여부")
    private String delYn;

    @ApiModelProperty(hidden = true)
    private EnumMapperValue enumMapperValue;



}
