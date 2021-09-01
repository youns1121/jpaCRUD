package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseDateEntity;
import com.jpacrud.dto.BoardCommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter

@Table(name = "board_comment")
@Entity
public class BoardComment extends BaseDateEntity { // 댓글 달기

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_comment_id")
    private Long boardCommentId;


    @Column(name="post_content")
    private String boardCommentContent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id")
    private Board Board;


    /**
     * 댓글쓰기
     */
    public void createComment(BoardCommentDto boardCommentDto){
        this.Board = boardCommentDto.getBoard();
        this.boardCommentContent = boardCommentDto.getBoardCommentContent();
    }

    /**
     * 대댓글 쓰기 : 댓글 -> 댓글
     */







}
