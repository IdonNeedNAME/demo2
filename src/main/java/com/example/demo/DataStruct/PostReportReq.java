package com.example.demo.DataStruct;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostReportReq {
    public int user_id;
    public int post_id;
    public String reason;
}
