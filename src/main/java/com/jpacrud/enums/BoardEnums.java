package com.jpacrud.enums;

import com.jpacrud.enums.Mapper.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;



public enum BoardEnums {
    ;

    @Getter
    @AllArgsConstructor
    public enum SearchCondition implements EnumMapperType{

        ALL(0, "전체"),
        CATEGORY(1, "카테고리"),
        TITLE(2, "제목"),
        WRITER(3, "작성자")
        ;

        private int statusCode;
        private String statusTitle;
    }


}
