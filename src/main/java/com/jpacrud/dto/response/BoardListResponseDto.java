package com.jpacrud.dto.response;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardComment;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Pageable;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @QueryProjection
    public BoardListResponseDto(Long categoryId, String categoryName, String boardTitle, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.boardTitle = boardTitle;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    //    public BoardListDto toEntity(Pageable pageable){
//        return BoardListDto.builder()
//                .categoryId(categoryId)
//                .boardId(boardId)
//                .boardTitle(boardTitle)
//                .createDate(createDate)
//                .build();
//    }
}
