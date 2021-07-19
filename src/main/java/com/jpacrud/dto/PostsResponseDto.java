package com.jpacrud.dto;

import com.jpacrud.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
