package com.example.demo.exception;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    DUPLICATE_USER(200000,"用户名已被占用"),

    ERROR_PASSWORD(200001,"密码错误"),
    NULL_USER(200002,"不存在的用户"),

    NULL_POST(200003,"不存在的帖子"),
    TOOLONG_CONTENT(200004,"内容过长"),
    LIMITED_AUTHORITY(200005,"权限不够"),
    NOTBELONGTO_POST(200006,"该贴不属于该用户"),
    NULL_REPORT(200007,"不存在的举报"),
    INVAILD_ACTION(200008,"无效操作");

    public final int errorCode;
    public final String errorMessage;
    ExceptionEnum(int errorCode, String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
}
