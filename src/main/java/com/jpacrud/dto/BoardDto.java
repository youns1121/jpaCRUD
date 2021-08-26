package com.jpacrud.dto;

import com.jpacrud.domain.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class BoardDto {

    @NotBlank
    @ApiModelProperty(value = "카테고리 제목")
    private Long categoryId;

    @ApiModelProperty(value = "게시판 아이디")
    private Long boardId;

    @ApiModelProperty(value = "게시판 제목")
    private String boardTitle;

    @ApiModelProperty(value = "게시판 내용")
    private String boardContent;


    @ApiModelProperty(hidden = true)
    private Category category;










}
