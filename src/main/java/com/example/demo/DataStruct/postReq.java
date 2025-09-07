package com.example.demo.DataStruct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class postReq {
    @JsonProperty("user_id")
    public int host;
    public String content;
}
