package com.jpacrud.domain;


import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.dto.BoardCommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "board_comment")
@Entity
public class BoardComment extends BaseEntity { // 댓글 달기

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_comment_id", columnDefinition = "BIGINT unsigned comment '게시판 댓글 아이디'")
    private Long boardCommentId;

    @Column(name="post_content")
    private String boardCommentContent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cateogry_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subscribe_id")
    private Subscribe subscribe;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "board_id")
    private Board Board;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "member_seq")
//    private Member member;

    /**
     * 댓글쓰기
     */
    @Builder
    public void createComment(BoardCommentDto boardCommentDto){
        this.Board = boardCommentDto.getBoard();
        this.boardCommentContent = boardCommentDto.getBoardCommentContent();
    }

    /**
     * 대댓글 쓰기 : 댓글 -> 댓글
     */







}
