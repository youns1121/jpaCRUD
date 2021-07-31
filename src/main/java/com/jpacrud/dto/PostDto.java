package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardPost;
import com.jpacrud.domain.PostReply;
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


    private Long boardId; // 게시판 아이디

    private Long postsId; // 게시글 아이디
    private String title; //제목
    private String content; // 내용



    private Board board; // 게시판
    private BoardPost boardPost;
    private PostReply Reply;
    private String replyContent;








}
