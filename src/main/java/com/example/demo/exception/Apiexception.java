package com.example.demo.exception;

public class Apiexception extends RuntimeException{
    public int errorCode;
    public String errorMessage;
    public Apiexception(int errorCode,String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
    public Apiexception(int errorCode,String errorMessage,Throwable cause){
        super(cause);
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
    public Apiexception(ExceptionEnum exceptionEnum){
        this.errorCode=exceptionEnum.errorCode;
        this.errorMessage=exceptionEnum.errorMessage;
    }
    public Apiexception(ExceptionEnum exceptionEnum,Throwable cause){
        super(cause);
        this.errorCode=exceptionEnum.errorCode;
        this.errorMessage=exceptionEnum.errorMessage;
    }
}
