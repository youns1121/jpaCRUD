package com.jpacrud.dto;

import com.jpacrud.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostsResponseDto { //조회 사용

    private Long postsId;
    private String title;
    private String author;
    private String content;

    public PostsResponseDto(Posts posts) {
        this.postsId = posts.getPostsId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.content = posts.getContent();
    }
}
