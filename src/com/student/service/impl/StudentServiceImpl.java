package com.student.service.impl;

import com.student.Utils.MyBatisUtil;
import com.student.mapper.StudentMapper;
import com.student.mapper.TeacherMapper;
import com.student.pojo.PageInfo;
import com.student.pojo.Student;
import com.student.service.StudentService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {


    @Override
    public PageInfo showPageInfo(String sname, String tname, String pageSizeStr, String pageNumberStr) {
        PageInfo pi=new PageInfo();

        int pageSize=2;
        if(pageSizeStr!=null&&pageNumberStr!=""){
            pageSize=Integer.parseInt(pageSizeStr);
        }
        int pageNumber=1;
        if(pageNumberStr!=null&&pageNumberStr!=""){
            pageNumber=Integer.parseInt(pageNumberStr);
        }

        SqlSession session= MyBatisUtil.getSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);

        pi.setPageStart((pageNumber-1)*pageSize);
        pi.setPageEnd(pageNumber*pageSize);
        pi.setPageNumber(pageNumber);
        pi.setPageSize(pageSize);
        pi.setTname(tname);
        pi.setSname(sname);
        List<Student> list=studentMapper.selByPage(pi);
        //查询每个学生对应的老师的信息
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        for(Student student :list){
            student.setTeacher(teacherMapper.selById(student.getTid()));
        }

        pi.setList(list);
        long total=studentMapper.selCountByPageInfo(pi);
        pi.setTotal(total%pageSize==0? total/pageSize:total/pageSize+1);

        return pi;
    }
}
