package com.jpacrud.domain;

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
public class PostComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_commit_id")
    private Long postCommentId;

    @Column(name = "post_title")
    private String postCommentTitle;

    @Column(name="post_content")
    private String postCommentContent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id")
    private BoardPost boardPost;




}
