package com.jpacrud.dto.response;


import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoardCommentResponseDto {

    @ApiModelProperty(value = "게시판 아이디", example = "0", required = true)
    private Long boardId;

    @ApiModelProperty(value = "게시판 답글 제목")
    private String boardReplyTitle;

    @ApiModelProperty(value = "게시판 답글 내용")
    private String boardReplyContent;

    @ApiModelProperty(hidden = true)
    private Board board;
    @ApiModelProperty(value = "게시판 댓글 아이디")
    private Long boardCommentId;

    @ApiModelProperty(value = "게시판 댓글 내용")
    private String boardCommentContent;

    @ApiModelProperty(hidden = true)
    private List<BoardComment> childComments = new ArrayList<>();

    @ApiModelProperty(hidden = true)
    private BoardComment boardComment;



}
