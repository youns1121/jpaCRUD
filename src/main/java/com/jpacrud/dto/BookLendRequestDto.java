package com.jpacrud.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookLendRequestDto {

    private Long bookId;
    private Long memberId;

}
