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

    @NotBlank
    @ApiModelProperty(value = "카테고리 제목")
    private Long categoryId;

    @ApiModelProperty(value = "게시판 아이디", hidden = true)
    private Long boardId;

    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "게시판 내용")
    private String boardContent;


    @ApiModelProperty(hidden = true)
    private Board board;

    public BoardDto toEntity(Board board) {

        return BoardDto.builder()
                .category(board.getCategory())
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .build();
    }


}


