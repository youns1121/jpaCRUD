package com.jpacrud.dto;

import com.jpacrud.domain.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    @ApiModelProperty(value = "카테고리 아이디",  notes = "카테고리 아이디")
    private Long categoryId;
    @ApiModelProperty(value = "카테고리 이름",  notes = "카테고리 이름")
    private String categoryName;

    @ApiModelProperty(hidden = true)
    private Category category;


}






