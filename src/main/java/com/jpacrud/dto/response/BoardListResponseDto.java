package com.jpacrud.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardListResponseDto {

    @ApiModelProperty(value = "카테고리 아이디", example = "0")
    private Long categoryId;

    @ApiModelProperty(value = "카테고리 이름")
    private String categoryName;


    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "게시판 생성시간")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "게시판 수정시간")
    private LocalDateTime modifyDate;

//    @ApiModelProperty(value = "플래그 상태값")
//    StatusEnums.FlagStatus flagStatus;

    @QueryProjection
    public BoardListResponseDto(Long categoryId, String categoryName, String boardTitle, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.boardTitle = boardTitle;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
