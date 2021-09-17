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

        NONE("권한없음"),
        SYSTEM_ADMIN( "시스템 관리자"),
        CATEGORY_ADMIN( "카테고리 관리자"),
        DEFAULT_USER( "일반 사용자"),
        ;

        private String statusTitle;
    }

    @Getter
    @AllArgsConstructor
    public enum Gender{

        M("남자"),
        F("여자"),
        ;

        private String statusTitle;
    }

    @Getter
    @AllArgsConstructor
    public enum PENALTY{

        CAUTION("주의"),
        WARNING("경고"),
        STOP("정지")
        ;

        private String statusTitle;
    }


}
