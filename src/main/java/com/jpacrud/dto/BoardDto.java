package com.jpacrud.dto;

import com.jpacrud.domain.Board;
import com.jpacrud.enums.BoardEnums;
import com.jpacrud.enums.StatusEnums;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BoardDto {




    @ApiModelProperty(value = "게시판 아이디")
    private Long boardId;

    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "게시판 내용")
    private String boardContent;



    @ApiModelProperty(hidden = true)
    private Board board;

    @ApiModelProperty(value = "게시판 생성시간", hidden = true)
    private LocalDateTime createDate;

    @ApiModelProperty(value = "게시판 수정시간", hidden = true)
    private LocalDateTime modifyDate;


    @ApiModelProperty(value = "삭제여부", hidden = true)
    private String delYn;


    @ApiModelProperty(value = "상태값", hidden = true)
    private StatusEnums.FlagStatus flagStatus;

    private BoardEnums.BoardCategory boardCategory;


//    @QueryProjection
    public BoardDto toEntity(Board board) {

        return BoardDto.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .build();
    }


}


