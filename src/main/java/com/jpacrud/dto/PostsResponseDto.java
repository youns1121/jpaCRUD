package com.jpacrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostsResponseDto { //조회 사용

    private Long postsId;
    private String title;
    private String author;
    private String content;


}
