package com.example.demo.service;

import com.example.demo.DataStruct.ApproveReq;
import com.example.demo.DataStruct.GetPostReportReq;
import com.example.demo.entity.post_report;

import java.util.List;

public interface adminservice {
    List<post_report> GetReportPostUncheck(GetPostReportReq req);
    boolean ApproveReport(ApproveReq req);
}
