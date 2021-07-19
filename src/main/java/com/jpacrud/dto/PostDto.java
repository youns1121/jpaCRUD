package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.Posts;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class PostDto {

    private String title; //제목
    private String content; // 내용





}
