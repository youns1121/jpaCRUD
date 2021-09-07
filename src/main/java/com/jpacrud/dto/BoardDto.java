package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.Category;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BoardDto {


    @ApiModelProperty(value = "카테고리 아이디")
    private Long categoryId;

    @ApiModelProperty(value = "게시판 아이디", hidden = true)
    private Long boardId;

    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "게시판 내용")
    private String boardContent;

    @ApiModelProperty(hidden = true)
    private Category category;

    @ApiModelProperty(hidden = true)
    private Board board;


    @ApiModelProperty(value = "게시판 생성시간", hidden = true)
    private LocalDateTime createDate;

    @ApiModelProperty(value = "게시판 수정시간", hidden = true)
    private LocalDateTime modifyDate;

//    @QueryProjection
    public BoardDto(Long categoryId, Long boardId, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.categoryId = categoryId;
        this.boardId = boardId;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }




    public BoardDto toEntity(Board board) {

        return BoardDto.builder()
                .category(board.getCategory())
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .build();
    }


}


