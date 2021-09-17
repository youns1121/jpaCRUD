package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.Category;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BoardDto {

    @ApiModelProperty(value = "게시판 아이디")
    private Long boardId;

    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "게시판 내용")
    private String boardContent;

    @ApiModelProperty(value = "게시판 생성시간", hidden = true)
    private LocalDateTime createDate;

    @ApiModelProperty(value = "게시판 수정시간", hidden = true)
    private LocalDateTime modifyDate;

    @ApiModelProperty(hidden = true)
    private Category category;

    @ApiModelProperty(hidden = true)
    private Board board;


}


