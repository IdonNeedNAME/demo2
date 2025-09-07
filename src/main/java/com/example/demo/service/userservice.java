package com.example.demo.service;

import com.example.demo.DataStruct.*;
import com.example.demo.entity.user;

public interface userservice {
    user Login(loginRequest req);
    boolean Register(RegistReq user);



}

