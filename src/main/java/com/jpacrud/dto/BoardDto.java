package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private Long boardId;
    @ApiModelProperty(value = "게시판 이름",  notes = "게시판 이름")
    private String boardName;

    @ApiModelProperty(hidden = true)
    private Board board;


}






