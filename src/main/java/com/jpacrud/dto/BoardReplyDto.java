package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardReplyDto {

    @ApiModelProperty(value = "게시판 아이디", example = "0", required = true)
    private Long boardId;

    @ApiModelProperty(value = "게시판 답글 제목")
    private String boardReplyTitle;

    @ApiModelProperty(value = "게시판 답글 내용")
    private String boardReplyContent;

    @ApiModelProperty(hidden = true)
    private Board board;



}
