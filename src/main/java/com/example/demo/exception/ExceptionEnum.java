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
    INVAILD_ACTION(200008,"无效操作"),
    TOOLONG_USERNAME(200009,"用户名过长"),
    TOOLONG_PASSWORD(200010,"密码过长"),
    INVAILD_PASSWORD(200011,"密码格式错误，密码必须包含数字和字母，且不能使用其他字符");

    public final int errorCode;
    public final String errorMessage;
    ExceptionEnum(int errorCode, String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
}
