package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseDateEntity;
import com.jpacrud.dto.PostCommentDto;
import com.jpacrud.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter

@Table(name = "board_post_comment")
@Entity
public class PostComment extends BaseDateEntity { // 댓글 달기

    @EmbeddedId
    private CommentAttr commentAttr;


    @Column(name="post_content")
    private String postCommentContent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id")
    private BoardPost boardPost;


    /**
     * 댓글쓰기
     */
    public void createComment(PostCommentDto postCommentDto){
        this.boardPost = postCommentDto.getBoardPost();
        this.postCommentContent = postCommentDto.getPostCommentContent();
    }

    /**
     * 대댓글 쓰기 : 댓글 -> 댓글
     */







}
