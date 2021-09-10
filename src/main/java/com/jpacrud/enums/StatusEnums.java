package com.jpacrud.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


public enum StatusEnums {
    ;

    @Getter
    @AllArgsConstructor
    public enum FlagStatus{

        FLAG_Y(1, "Y"),
        FLAG_N(0, "N")
        ;

        private int statusCode;
        private String statusMsg;
    }

    @Getter
    @AllArgsConstructor
    public enum UserRole {

        SYSTEM_ADMIN(0, "시스템관리자"),
        BOARD_ADMIN(1, "게시판관리자"),
        USER_NONE(2, "일반사용자"),
        ;

        private int statusCode;
        private String statusMsg;


    }
}
