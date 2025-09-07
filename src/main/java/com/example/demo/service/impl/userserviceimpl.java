package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DataStruct.*;
import com.example.demo.exception.Apiexception;
import com.example.demo.exception.ExceptionEnum;
import com.example.demo.service.userservice;
import jakarta.annotation.Resource;
import com.example.demo.mapper.userMapper;
import com.example.demo.entity.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class userserviceimpl implements userservice {
    @Resource
    public userMapper Userdata;
    @Override
    public user Login(loginRequest req)
    {
         String na=req.username;
         QueryWrapper<user> dataWra=new QueryWrapper<>();
         dataWra.eq("username",na);
         user user1=Userdata.selectOne(dataWra);
         if(user1==null)
         {
              throw new Apiexception(ExceptionEnum.NULL_USER);
         }
         else
         {
             if(!req.password.equals(user1.password))
                throw new Apiexception(ExceptionEnum.ERROR_PASSWORD);
         }
         return user1;
    }
    @Override
    public boolean Register(RegistReq req)
    {
        String na=req.username;
        QueryWrapper<user> dataWra=new QueryWrapper<>();
        dataWra.eq("username",na);
        user user1=Userdata.selectOne(dataWra);
        user nu;
        if(user1!=null)
        {
            throw new Apiexception(ExceptionEnum.DUPLICATE_USER);
        }
        else
        {
            if(req.username.length()>10)
                throw new Apiexception(ExceptionEnum.TOOLONG_USERNAME);
            if(req.password.length()>20)
                throw new Apiexception(ExceptionEnum.TOOLONG_PASSWORD);
            if(!IsPassWordVaild(req.password))
                throw new Apiexception(ExceptionEnum.INVAILD_PASSWORD);
            nu=user.builder().username(req.username).password(req.password).name(req.name).user_type(req.user_type).build();
            Userdata.insert(nu);
        }
        return true;
    }
    public boolean  IsPassWordVaild(String password)
    {
        boolean num=false,letter=false;
        for(int i=0;i<password.length();i++)
        {
            int asc=(int)password.charAt(i);
            if((asc>=(int)'A'&&asc<=(int)'Z')||(asc>=(int)'a'&&asc<=(int)'z'))
                letter=true;
            else
            if(asc>=(int)'0'&&asc<=(int)'9')
                num=true;
            else
                return false;
        }
        return num&&letter;
    }


}
