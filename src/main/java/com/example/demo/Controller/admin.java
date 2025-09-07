package com.example.demo.Controller;

import com.example.demo.DataStruct.ApproveReq;
import com.example.demo.DataStruct.GetPostReportReq;
import com.example.demo.DataStruct.AjaxResult;
import com.example.demo.entity.post_report;
import com.example.demo.exception.Apiexception;
import com.example.demo.service.impl.adminserviceimpl;
import com.example.demo.service.impl.postserviceimpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@Slf4j
public class admin {
    @Resource
    adminserviceimpl adminservice;
    @Resource
    postserviceimpl postservice;
    @GetMapping("/report")
    public AjaxResult<List<post_report>> GetReportPostUncheck(@RequestParam int user_id)
    {
        GetPostReportReq req = new GetPostReportReq(user_id);
        List<post_report> reports;
        try
        {
            reports=adminservice.GetReportPostUncheck(req);
        }
        catch(Apiexception ex)
        {
            return AjaxResult.GenRes_Exception(ex);
        }
        return AjaxResult.GenRes_Succ(reports);
    }
    @PostMapping("/report")
    public AjaxResult ApproveReport(@RequestBody ApproveReq req)
    {
        try
        {
            adminservice.ApproveReport(req);
        }
        catch(Apiexception ex)
        {
            return AjaxResult.GenRes_Exception(ex);
        }
            return AjaxResult.GenRes_Succ(null);
    }
}
