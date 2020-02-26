package com.student.mapper;

import com.student.pojo.PageInfo;
import com.student.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selByPage(PageInfo pi);

    long selCountByPageInfo(PageInfo pi);
}
