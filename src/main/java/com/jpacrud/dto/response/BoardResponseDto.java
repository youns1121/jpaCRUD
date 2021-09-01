package com.jpacrud.dto.response;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardResponseDto {

    @ApiModelProperty(value = "카테고리 아이디")
    private Long categoryId;
    @ApiModelProperty(value = "카테고리 이름")
    String categoryName;

    @ApiModelProperty(value = "게시판 아이디", example = "0", required = true)
    private Long boardId;

    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "생성 시간")
    private LocalDateTime createDate;




    public BoardResponseDto toEntity(Board board){
        return BoardResponseDto.builder()
                .boardId(board.getBoardId())
                .boardTitle(board.getBoardTitle())
                .createDate(board.getCreateDate())
                .categoryId(board.getCategory().getCategoryId())
                .categoryName(board.getCategory().getCategoryName())
                .build();
    }
}
