package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseDateEntity;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.BoardMgmtDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="board")
public class Board extends BaseDateEntity { //게시판

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "board_name")
    private String boardName;


    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<BoardPost> boardPostList = new ArrayList<>();





    public void create(BoardDto boardDto){
        this.boardName = boardDto.getBoardName();
    }


    /**
     * 게시판 생성
     * @param boardDto
     * @return
     */
//    public static Board createBoard(BoardDto boardDto){
//        return Board.builder()
//                .boardName(boardDto.getBoardName())
//                .build();
//    }

    /**
     * 게시판 수정
     */




}
