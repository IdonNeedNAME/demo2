package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.DataStruct.*;
import com.example.demo.Help.Helper;
import com.example.demo.entity.post;
import com.example.demo.entity.post_report;
import com.example.demo.exception.Apiexception;
import com.example.demo.exception.ExceptionEnum;
import com.example.demo.mapper.postMapper;
import com.example.demo.mapper.post_reportMapper;
import com.example.demo.mapper.userMapper;
import com.example.demo.service.postservice;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class postserviceimpl implements postservice {
    @Resource
    public userMapper Userdata;
    @Resource
    public postMapper Postdata;
    @Resource
    public post_reportMapper PostReportdata;
    @Resource
    public Helper helper;

    @Override
    public boolean Addpost(postReq post)
    {

        if(!helper.UserExist(post.host))
            throw new Apiexception(ExceptionEnum.NULL_USER);
        if(post.content.length()>1000)
            throw new Apiexception(ExceptionEnum.TOOLONG_CONTENT);
        post p=new post(post.host,post.content);
        Postdata.insert(p);
        return true;
    }
    @Override
    public List<post> CheckAllpost()
    {
        return Postdata.selectList(null);
    }
    @Override
    public boolean Hidepost(HidePostReq req)
    {
        if(!helper.UserExist(req.user_id))
            throw new Apiexception(ExceptionEnum.NULL_USER);
        if(!helper.PostExist(req.post_id))
            throw new Apiexception(ExceptionEnum.NULL_POST);
        if(!helper.UserAuthorityCheck(req.user_id,2))
            throw new Apiexception(ExceptionEnum.LIMITED_AUTHORITY);
        UpdateWrapper<post> dataWra=new UpdateWrapper<>();
        dataWra.eq("id",req.post_id).set("hide",true);
        Postdata.update(dataWra);
        return true;
    }
    @Override
    public boolean ReportPost(PostReportReq req)
    {
        if(!helper.UserExist(req.user_id))
            throw new Apiexception(ExceptionEnum.NULL_USER);
        if(!helper.PostExist(req.post_id))
            throw new Apiexception(ExceptionEnum.NULL_POST);
        QueryWrapper<post> dataWra=new QueryWrapper<>();
        dataWra.eq("id",req.post_id);
        post post=Postdata.selectOne(dataWra);
        if(post!=null)
        {
            PostReportdata.insert(new post_report(req.user_id,req.post_id,req.reason));
            return true;
        }
        return false;
    }
    @Override
    public boolean PostUpdate(postUpdateReq req)
    {
        if(!helper.UserExist(req.host))
            throw new Apiexception(ExceptionEnum.NULL_USER);
        if(!helper.PostExist(req.post_id))
            throw new Apiexception(ExceptionEnum.NULL_POST);
        QueryWrapper<post> dataWra=new QueryWrapper<>();
        dataWra.eq("id",req.post_id);
        post p= Postdata.selectOne(dataWra);

        p.content=req.content;
        Postdata.update(p,dataWra);
        return  true;
    }
    @Override
    public int Getlikes_post(GetLikePostReq req)
    {
        QueryWrapper<post> dataWra=new QueryWrapper<>();
        dataWra.eq("id",req.post_id).eq("host_id",req.user_id);
        post p= Postdata.selectOne(dataWra);
        if(p==null)
            return -1;
        else
            return  p.likes;
    }
    @Override
    public boolean AddLikes_Post(AddLikePostReq req)
    {
        QueryWrapper<post> dataWra=new QueryWrapper<>();
        dataWra.eq("id",req.post_id).eq("host_id",req.user_id);
        post p= Postdata.selectOne(dataWra);
        if(p==null)
            return false;
        else
        {
            p.likes++;
            Postdata.update(p,dataWra);
        }
        return true;
    }
    @Override
    public List<post_report> GetReportPost(GetPostReportReq req)
    {
        if(!helper.UserExist(req.user_id))
            throw new Apiexception(ExceptionEnum.NULL_USER);
        QueryWrapper<post_report> dataWra=new QueryWrapper<>();
        dataWra.eq("reporter",req.user_id);
        return PostReportdata.selectList(dataWra);
    }
}
