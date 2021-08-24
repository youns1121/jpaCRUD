package com.jpacrud.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    STATUS_SUCCESS(1, "성공"),
    STATUS_FAIL(0, "실패")
    ;

    private int statusCode;
    private String statusMsg;
}
