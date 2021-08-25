package com.jpacrud.exception;

public class BoardIdEmptyException extends RuntimeException{

//    //객체를 구분 할때 일단 주석처리
//    private static final long serialVersionUID = 1L;

    public BoardIdEmptyException(String message){
        super(message);
    }


}
