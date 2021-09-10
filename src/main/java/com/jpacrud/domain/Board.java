package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "board")
@Entity
public class Board extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name="board_content")
    private String boardContent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="category_id")
    private Category category;

    @Builder.Default
    @OneToMany(mappedBy = "board")
    private List<BoardReply> boardReplyList = new ArrayList<>();


    /**
     * 게시판 생성 로직
     */
    public void createBoard(BoardDto boardDto) {

        this.category = boardDto.getCategory();
        this.boardTitle = boardDto.getBoardTitle();
        this.boardContent = boardDto.getBoardContent();
    }






    /**
     * 댓글 생성 로직
     */

//    public void replyPost(CategoryPostReplyDto replyDto) {
//
//        PostReply postReply = new PostReply();
//        postReply.create(replyDto);
//
//
//    }



//    public void createReply(CategoryPostReplyDto replyDto){
//
//
//        CategoryPostReply CategoryPostReply = new CategoryPostReply();
//        CategoryPostReply.create(replyDto);
//    }

    /**
     * 업데이트 로직
     */







}
