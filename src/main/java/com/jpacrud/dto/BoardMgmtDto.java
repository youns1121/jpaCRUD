package com.jpacrud.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardMgmtDto {

    private BoardDto boardDto;
    private PostDto postDto;
}
