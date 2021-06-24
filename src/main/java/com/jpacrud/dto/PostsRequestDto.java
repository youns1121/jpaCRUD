package com.jpacrud.dto;

import com.jpacrud.domain.Posts;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder

public class PostsRequestDto {

    private String author; // 작성자명
    private String title; //제목
    private String content; // 내용





    public PostsRequestDto(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public PostsRequestDto() {
    }

//    public PostsRequestDto from (Posts post){
//        return PostsRequestDto.builder()
//                .author(post.getAuthor())
//                .title(post.getTitle())
//                .content(post.getContent())
//                .build();
//    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }
}
