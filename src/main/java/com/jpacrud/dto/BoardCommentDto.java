package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BoardCommentDto {

    @ApiModelProperty(value = "게시판 아이디")
    private Long boardId;

    @ApiModelProperty(value = "게시판 댓글 아이디")
    private Long boardCommentId;

    @ApiModelProperty(value = "게시판 댓글 내용")
    private String boardCommentContent;

    @ApiModelProperty(hidden = true)
    private List<BoardComment> childComments = new ArrayList<>();

    @ApiModelProperty(hidden = true)
    private Board board;

    @ApiModelProperty(hidden = true)
    private BoardComment boardComment;




}
