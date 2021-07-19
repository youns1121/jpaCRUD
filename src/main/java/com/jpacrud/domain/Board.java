package com.jpacrud.domain;

import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.BoardMgmtDto;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="board")
public class Board { //게시판

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "board_name")
    private String name;

    @OneToMany(mappedBy = "board")
    private List<Posts> postsList = new ArrayList<>();


    public static Board choiceBoard(BoardMgmtDto boardMgmtDto){
        return Board.builder()
                .boardId(boardMgmtDto.getBoardDto().getBoardId())
                .build();
    }

    //게시판 생성 로직
    private static Board create(BoardDto boardDto){
        return Board.builder()
                .name(boardDto.getName())
                .build();
    }

    /**
     * 게시판 생성 : ex 자유게시판
     */
    public static Board createBoard(BoardMgmtDto boardMgmtDto){
        Board board = create(boardMgmtDto.getBoardDto());

        return board;
    }

    /**
     * 게시물 생성 : ex 자유게시판 - 글 작성
     */

    public static Board createPosts(BoardMgmtDto boardMgmtDto){
        Board board = choiceBoard(boardMgmtDto);
        board.postsList = (List<Posts>) Posts.create(boardMgmtDto);
        return board;



    }





}
