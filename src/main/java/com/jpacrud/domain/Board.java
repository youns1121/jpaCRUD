package com.jpacrud.domain;

import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.BoardMgmtDto;
import lombok.*;

import javax.persistence.*;
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
    private String boardName;

    @OneToMany(mappedBy = "board")
    private List<BoardPost> postsList = new ArrayList<>();



    private void create(BoardDto boardDto){
        this.boardName = boardDto.getBoardName();
    }


    public static Board createBoard(BoardDto boardDto){
        return Board.builder()
                .boardName(boardDto.getBoardName())
                .build();
    }




}
