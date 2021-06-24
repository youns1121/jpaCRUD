package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardDto {

    private Long boardId;
    private String name;





    public BoardDto(Long boardId, String name) {
        this.boardId = boardId;
        this.name = name;

    }
}
