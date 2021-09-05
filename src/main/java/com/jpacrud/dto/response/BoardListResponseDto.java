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

@NoArgsConstructor
@Builder
public class BoardListResponseDto {


    @ApiModelProperty(value = "카테고리 아이디", example = "0")
    private Long categoryId;

    @ApiModelProperty(value = "카테고리 이름")
    private Long categoryName;

    @ApiModelProperty(value = "게시판 아이디", example = "0")
    private Long boardId;

    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @QueryProjection

    public BoardListResponseDto(Long categoryId, Long categoryName, Long boardId, String boardTitle) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.boardId = boardId;
        this.boardTitle = boardTitle;
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
