package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DataStruct.ApproveReq;
import com.example.demo.DataStruct.GetPostReportReq;
import com.example.demo.Help.Helper;
import com.example.demo.entity.post;
import com.example.demo.entity.post_report;
import com.example.demo.exception.Apiexception;
import com.example.demo.exception.ExceptionEnum;
import com.example.demo.mapper.postMapper;
import com.example.demo.mapper.post_reportMapper;
import com.example.demo.service.adminservice;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class adminserviceimpl  implements adminservice {
    @Resource
    public postMapper Postdata;
    @Resource
    public post_reportMapper PostReportdata;
    @Resource
    public Helper helper;
    @Override
    public List<post_report> GetReportPostUncheck(GetPostReportReq req)
    {

        if(!helper.UserAuthorityCheck(req.user_id,2))
            throw new Apiexception(ExceptionEnum.LIMITED_AUTHORITY);
        QueryWrapper<post_report> dataWra=new QueryWrapper<>();
        dataWra.eq("status",0);
        List<post_report> reports;
        reports= PostReportdata.selectList(dataWra);
            return reports;

    }
    @Override
    public boolean ApproveReport(ApproveReq req)
    {
        if(!helper.UserExist(req.user_id))
            throw new Apiexception(ExceptionEnum.NULL_USER);
        if(!helper.UserAuthorityCheck(req.user_id,2))
            throw new Apiexception(ExceptionEnum.LIMITED_AUTHORITY);

        QueryWrapper<post_report> dataWra=new QueryWrapper<>();
        QueryWrapper<post> dataWra1=new QueryWrapper<>();
        post post;
        dataWra.eq("id",req.report_id);
        post_report report= PostReportdata.selectOne(dataWra);
        if(!helper.PostReportExist(req.report_id))
            throw new Apiexception(ExceptionEnum.NULL_REPORT);
        else
        {

            dataWra1.eq("id",report.post);
            post= Postdata.selectOne(dataWra1);
            if(post==null)
                throw new Apiexception(ExceptionEnum.NULL_POST);
            else
            {
                if(req.approval==1)
                    post.hide=true;
                else
                if(req.approval==2)
                    post.hide=false;
                else
                    throw new Apiexception(ExceptionEnum.INVAILD_ACTION);
            }
        }
        Postdata.update(post,dataWra1);
        report.status=1;
        PostReportdata.update(report,dataWra);
        return true;

    }
}
