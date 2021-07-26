package com.jpacrud.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostsResponseDto { //조회 사용


    private Long boardId; // 게시판 아이디
    private Long postsId; // 게시글 아이디
    private String title; //제목
    private String content; // 내용


}
