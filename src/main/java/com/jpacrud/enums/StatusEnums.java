package com.jpacrud.enums;

import com.jpacrud.enums.Mapper.EnumMapperType;
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
    public enum UserRole{

        SYSTEM_ADMIN( "시스템관리자"),
        BOARD_ADMIN( "게시판관리자"),
        USER_NONE( "일반사용자"),



        ;


        private String statusTitle;

    }


}
