package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardPost;
import com.jpacrud.domain.PostReply;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class PostDto {

    @NotBlank
    @ApiModelProperty(value = "게시판 제목")
    private Long boardId;

    @ApiModelProperty(value = "게시글 아이디")
    private Long postsId;

    @ApiModelProperty(value = "게시글 제목")
    private String title; //제목

    @ApiModelProperty(value = "게시글 내용")
    private String content; // 내용


    @ApiModelProperty(hidden = true)
    private Board board;










}
