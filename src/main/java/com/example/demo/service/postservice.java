package com.example.demo.service;

import com.example.demo.DataStruct.*;
import com.example.demo.entity.post;
import com.example.demo.entity.post_report;

import java.util.List;

public interface postservice {
    boolean Addpost(postReq post);
    List<post> CheckAllpost();
    boolean Hidepost(HidePostReq req);
    boolean ReportPost(PostReportReq req);
    boolean PostUpdate(postUpdateReq req);
    int Getlikes_post(GetLikePostReq req);
    boolean AddLikes_Post(AddLikePostReq req);
    List<post_report> GetReportPost(GetPostReportReq req);
}
