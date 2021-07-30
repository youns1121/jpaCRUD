package com.jpacrud.dto;

import com.jpacrud.domain.BoardPost;
import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PostCommentDto {

    private Long postCommentId;

    private String postCommentTitle;

    private String postCommentContent;

    private BoardPost boardPost;
}
