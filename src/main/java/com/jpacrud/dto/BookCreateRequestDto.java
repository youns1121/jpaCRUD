package com.jpacrud.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookCreateRequestDto {
    private String bookName;
    private String bookIsbn;
    private Long authorId;
}
