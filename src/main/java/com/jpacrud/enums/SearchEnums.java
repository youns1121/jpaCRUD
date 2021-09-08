package com.jpacrud.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public enum SearchEnums {

    ;

    @Getter
    @AllArgsConstructor
    public enum SearchCondition{

        ALL(0, "전체"),
        CATEGORY(1, "카테고리"),
        TITLE(2, "제목"),
        WRITER(3, "작성자")
        ;

        private int statusCode;
        private String statusMsg;
    }
}
