package com.example.demo.Help;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.post;
import com.example.demo.entity.post_report;
import com.example.demo.entity.user;
import com.example.demo.mapper.postMapper;
import com.example.demo.mapper.post_reportMapper;
import com.example.demo.mapper.userMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Helper {
    @Resource
    public userMapper Userdata;
    @Resource
    public postMapper Postdata;
    @Resource
    public post_reportMapper PostReportdata;
    public boolean UserExist(int id)
    {
        QueryWrapper<user> user=new QueryWrapper<user>();
        user.eq("id",id);
        user user1=Userdata.selectOne(user);
        if(user1==null)
            return false;
        else
            return true;
    }
    public boolean UserAuthorityCheck(int id,int least)
    {
        QueryWrapper<user> user=new QueryWrapper<user>();
        user.eq("id",id);
        user user1=Userdata.selectOne(user);

        if(user1.user_type <least)
            return false;
        else
            return true;
    }
    public boolean PostExist(int id)
    {
        QueryWrapper<post> po=new QueryWrapper<post>();
        po.eq("id",id);
        post post1=Postdata.selectOne(po);
        if(post1==null)
            return false;
        else
            return true;
    }
    public boolean PostReportExist(int id)
    {
        QueryWrapper<post_report> po=new QueryWrapper<post_report>();
        po.eq("id",id);
        post_report post1=PostReportdata.selectOne(po);
        if(post1==null)
            return false;
        else
            return true;
    }
}
