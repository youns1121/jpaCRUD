package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.enums.BoardEnums;
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
    @JoinColumn(name="seq")
    private Member member;

    @OneToMany(mappedBy = "board")
    private List<Category> categoryList = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    private List<BoardReply> boardReplyList = new ArrayList<>();


    @Column(name = "board_category")
    private BoardEnums.BoardCategory boardCategory;




    /**
     * 게시판 생성 로직
     */
    public void createBoard(BoardDto boardDto) {

        this.boardCategory = boardDto.getBoardCategory();
        this.boardTitle = boardDto.getBoardTitle();
        this.boardContent = boardDto.getBoardContent();
    }

    public void deleteBoard(BoardDto boardDto){


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
