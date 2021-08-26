package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.dto.BoardReplyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "board_reply")
@Entity
public class BoardReply extends BaseEntity { //답글 생성

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_reply_id")
    private Long boardReplyId;

    @Column(name ="board_reply_title")
    private String boardReplyTitle;

    @Column(name = "board_reply_content")
    private String boardReplyContent;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "board_id")
    private Board board;


    /**
     *  답글 생성 로직
     */

    public void create(BoardReplyDto replyDto){

        this.board = replyDto.getBoard();
        this.boardReplyTitle = replyDto.getBoardReplyTitle();
        this.boardReplyContent = replyDto.getBoardReplyContent();

    }


}
