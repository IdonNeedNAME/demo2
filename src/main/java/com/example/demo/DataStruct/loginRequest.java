package com.example.demo.DataStruct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class loginRequest {

    public String username;

    public String password;
}
