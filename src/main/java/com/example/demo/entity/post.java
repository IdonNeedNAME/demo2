package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@TableName(value = "post")
@Data
@Builder
@AllArgsConstructor
@Setter
public class post {
    public static String nulltitle="UndefinedPost";
    public post(int host_id,String content)
    {
        title=nulltitle;
        this.content=content;
        this.host_id=host_id;
        hide=false;
        likes=0;
    }
    @TableId(type= IdType.AUTO)
    public int id;
    public int host_id;
    public String title;
    public String content;
    public boolean hide=false;
    public int likes=0;
}
