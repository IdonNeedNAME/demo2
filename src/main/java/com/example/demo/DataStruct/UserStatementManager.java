package com.example.demo.DataStruct;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class UserStatementManager {
    public short Type;
    public Time lastLogin;
}
