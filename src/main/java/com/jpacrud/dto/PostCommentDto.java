package com.jpacrud.dto;

import com.jpacrud.domain.BoardPost;
import com.jpacrud.domain.PostComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PostCommentDto {


    private Long postsId;

    private Long postCommentId;

    private List<PostComment> childPostComments = new ArrayList<>();


    private String postCommentContent;

    @ApiModelProperty(hidden = true)
    private BoardPost boardPost;

    @ApiModelProperty(hidden = true)
    private PostComment postComment;




}
