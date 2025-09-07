package com.example.demo.Controller;
import com.example.demo.DataStruct.RegistReq;
import com.example.demo.DataStruct.UniRes;
import com.example.demo.entity.user;
import com.example.demo.exception.Apiexception;
import com.example.demo.service.impl.userserviceimpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.example.demo.DataStruct.loginRes;
import com.example.demo.DataStruct.loginRequest;


@RestController
@RequestMapping("/api/user")
@Slf4j
public class control {
    @Resource
    userserviceimpl userservice;
    @PostMapping("/login")
    public UniRes<loginRes> login(@RequestBody loginRequest da)
    {
           loginRes res=new loginRes();
           user user1;
           try {
               user1=userservice.Login(da);
           }
           catch(Apiexception ex)
           {
               return UniRes.GenRes_Exception(ex,null);
           }

               res.user_id=user1.id;
               res.user_type=user1.user_type;
               return UniRes.GenRes_Succ(res);

    }
    @PostMapping("/reg")
    public UniRes regist(@RequestBody RegistReq da)
    {
        try
        {
            userservice.Register(da);
        }
        catch(Apiexception ex)
        {
            return UniRes.GenRes_Exception(ex);
        }
        return UniRes.GenRes_Succ(null);
    }


    @GetMapping("/login")
    public int f()
    {
        log.info("enter1");
        return -1;
    }
}
