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



    private Long commentId;
    private Long commentGroupId;

    private String postCommentContent;

    private BoardPost boardPost;

    private Long postsId;



}
