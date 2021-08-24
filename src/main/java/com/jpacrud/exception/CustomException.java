package com.jpacrud.exception;

public class CustomException extends RuntimeException{

    //객체를 구분 할떄
    private static final long serialVersionUID = 1L;

    public CustomException(String message){
        super(message);
    }


}
