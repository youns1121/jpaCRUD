package com.jpacrud.dto;

import com.jpacrud.domain.BoardPost;
import com.jpacrud.domain.PostReply;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardPostReplyDto { // 답글 생성

    @ApiModelProperty(value = "게시글 아이디", example = "0", required = true)
    private Long postsId;

    @ApiModelProperty(value = "답글 제목")
    private String postReplyTitle;

    @ApiModelProperty(value = "답글 내용")
    private String postReplyContent;

    @ApiModelProperty(hidden = true)
    private BoardPost boardPost;



}
