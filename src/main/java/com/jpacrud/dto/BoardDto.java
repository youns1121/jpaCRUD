package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private Long boardId;
    private String name;




//    public BoardDto toEntity(BoardMgmtDto boardMgmtDto){
//        return BoardDto.builder()
//                .name(boardMgmtDto.getBoardDto().getName())
//                .build();


}
