package com.example.demo.DataStruct;

import com.example.demo.exception.Apiexception;

public class AjaxResult<T> {
    public static String succ="success",Fail="fail";
    public int  code;
    public String msg;
    public T data;
    public AjaxResult(int code, String message, T data){
        this.code=code;
        this.msg=message;
        this.data=data;
    }

    public static <T> AjaxResult<T> GenRes_Succ(T da)
    {
           return new AjaxResult<T>(200,succ,da);
    }
    public static <T> AjaxResult<T> GenRes_Fail(T da) {
        return new AjaxResult<T>(200, Fail, null);
    }
    public static <T> AjaxResult<T> GenRes_Exception(Apiexception exception, T da) {
        return new AjaxResult<T>(exception.errorCode, exception.errorMessage, da);
    }
    public static <T> AjaxResult<T> GenRes_Exception(Apiexception exception) {
        return new AjaxResult<T>(exception.errorCode, exception.errorMessage, null);
    }

}
