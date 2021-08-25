package com.jpacrud.dto;

import com.jpacrud.domain.BoardPost;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PostCommentDto {


    private Long postsId;

    private Long postCommentId;


    private String postCommentContent;

    @ApiModelProperty(hidden = true)
    private BoardPost boardPost;




}
