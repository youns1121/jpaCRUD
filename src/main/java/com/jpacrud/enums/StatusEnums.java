package com.jpacrud.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


public enum StatusEnums {
    ;

    @Getter
    @AllArgsConstructor
    public enum FlagStatus{

        FLAG_Y(1, "성공"),
        FLAG_N(0, "실패")
        ;

        private int statusCode;
        private String statusMsg;


    }

    @Getter
    @AllArgsConstructor
    public enum UserRole {

        USER_NONE("일반사용자"),
        BOARD_ADMIN("게시판관리자"),
        SYSTEM_ADMIN("시스템관리자")
        ;

        private String statusMsg;


    }
}
