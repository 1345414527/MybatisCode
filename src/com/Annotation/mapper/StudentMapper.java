package com.Annotation.mapper;

import com.Annotation.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select s.id ,s.name ,age ,tid,t.id 'teacher.id' ,t.name 'teacher.name'  from student s left join teacher t on s.tid=t.id")
    List<Student> selAll();

    @Select("select * from STUDENT where tid=#{0}")
    List<Student> selById(int id);
}
