package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "post_report")
@Data
@Builder
@AllArgsConstructor
public class post_report {

    public post_report(int reporter,int post,String reason)
    {
        this.reporter=reporter;
        this.post=post;
        this.reason=reason;
        status =0;
    }
    @TableId(type= IdType.AUTO)
    public int id;
    public int reporter;
    public int post;
    public String reason;
    public int status;

}
