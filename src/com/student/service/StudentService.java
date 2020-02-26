package com.student.service;

import com.student.pojo.PageInfo;

public interface StudentService {
    PageInfo showPageInfo(String sname,String tname,String pageSizeStr,String pageNumberStr);
}
