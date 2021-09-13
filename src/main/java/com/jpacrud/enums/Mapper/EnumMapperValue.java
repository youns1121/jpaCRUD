package com.jpacrud.enums.Mapper;

import lombok.Getter;

@Getter
public class EnumMapperValue {

    private int statusCode;
    private String statusTitle;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        statusCode = enumMapperType.getStatusCode();
        statusTitle = enumMapperType.getStatusTitle();
    }



}
