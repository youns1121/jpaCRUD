package com.jpacrud.domain;

public enum MemberStatus { //계정 활성 여부
    ACTIVE("avtive"), //활성화
    DEACTIVATED("deactivated"); //비활성화

    private String value;

    MemberStatus(String value) {
        this.value = value;


    }
}
