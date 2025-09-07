package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "user")
@Data
@Builder
@AllArgsConstructor
public class user {
    public user(String username,String password,int type){
           this.username=username;
           this.password=password;
           this.user_type =type;
    }
    @TableId(type= IdType.AUTO)
    public int id;
    public String username;
    public String password;
    public String name;
    public int user_type;
}
