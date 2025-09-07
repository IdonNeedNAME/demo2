package com.example.demo.DataStruct;

import com.example.demo.exception.Apiexception;

public class UniRes<T> {
    public static String succ="success",Fail="fail";
    public int  code;
    public String msg;
    public T data;
    public UniRes(int code,String message,T data){
        this.code=code;
        this.msg=message;
        this.data=data;
    }

    public static <T> UniRes<T> GenRes_Succ(T da)
    {
           return new UniRes<T>(200,succ,da);
    }
    public static <T> UniRes<T> GenRes_Fail(T da) {
        return new UniRes<T>(200, Fail, null);
    }
    public static <T> UniRes<T> GenRes_Exception(Apiexception exception,T da) {
        return new UniRes<T>(exception.errorCode, exception.errorMessage, da);
    }
    public static <T> UniRes<T> GenRes_Exception(Apiexception exception) {
        return new UniRes<T>(exception.errorCode, exception.errorMessage, null);
    }

}
