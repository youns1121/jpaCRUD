package com.jpacrud.dto.response;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardComment;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardListResponseDto {



    @ApiModelProperty(value = "게시판 아이디", example = "0", required = true)
    private Long boardId;

    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "생성 시간")
    private LocalDateTime createDate;





//    public BoardListDto toEntity(Pageable pageable){
//        return BoardListDto.builder()
//                .categoryId(categoryId)
//                .boardId(boardId)
//                .boardTitle(boardTitle)
//                .createDate(createDate)
//                .build();
//    }
}
