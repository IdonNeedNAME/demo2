package com.example.demo.Controller;
import com.example.demo.DataStruct.*;
import com.example.demo.entity.post;
import com.example.demo.entity.post_report;
import com.example.demo.exception.Apiexception;
import com.example.demo.service.impl.postserviceimpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/student")
@Slf4j
public class stutent {
    @Resource
    public postserviceimpl postservice;
    @PostMapping("/post")
    public AjaxResult<String> Addpost(@RequestBody postReq da)
    {
        try
        {
            postservice.Addpost(da);
        }
        catch(Apiexception ex)
        {
            return AjaxResult.GenRes_Exception(ex);
        }
        return AjaxResult.GenRes_Succ(null);

    }
    @GetMapping("/post")
    public AjaxResult<List<post>> CheckAllpost()
    {
        return AjaxResult.GenRes_Succ(postservice.CheckAllpost());
    }
    @DeleteMapping("/post")
    public AjaxResult Hidepost(@RequestParam int user_id, @RequestParam int post_id)
    {
        HidePostReq req = new HidePostReq();
        req.user_id=user_id;
        req.post_id=post_id;

        try
        {
            postservice.Hidepost(req);
        }
        catch(Apiexception ex)
        {
            return AjaxResult.GenRes_Exception(ex);
        }
        return AjaxResult.GenRes_Succ(null);

    }
    @PostMapping("/report-post")
    public AjaxResult Addreport_post(@RequestBody PostReportReq req)
    {
        try
        {
            postservice.ReportPost(req);
        }
        catch(Apiexception ex)
        {
            return AjaxResult.GenRes_Exception(ex);
        }
            return AjaxResult.GenRes_Succ(null);
    }
    @PutMapping("/post")
    public AjaxResult postupdate(@RequestBody postUpdateReq req)
    {

        try
        {
            postservice.PostUpdate(req);
        }
        catch(Apiexception ex)
        {
            return AjaxResult.GenRes_Exception(ex);
        }
        return AjaxResult.GenRes_Succ(null);
    }
    @GetMapping("/likes")
    public AjaxResult Getlikes(@RequestParam int user_id, @RequestParam int post_id)
    {

        GetLikePostReq req = new GetLikePostReq();
        req.user_id=user_id;
        req.post_id=post_id;
        int likes=postservice.Getlikes_post(req);
        if(likes!=-1)
            return AjaxResult.GenRes_Succ(new GetLikeRes(likes));
        else
            return AjaxResult.GenRes_Fail(null);
    }
    @GetMapping("/report-post")
    public AjaxResult<List<post_report>> GetReport(@RequestParam int user_id)
    {

        GetPostReportReq req = new GetPostReportReq(user_id);
        List<post_report> reports;
        try
        {
            reports=postservice.GetReportPost(req);
        }
        catch(Apiexception ex)
        {
            return AjaxResult.GenRes_Exception(ex);
        }
        return AjaxResult.GenRes_Succ(reports);
    }
}
