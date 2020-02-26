package com.Annotation.mapper;

import com.Annotation.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> selAll();

    @Insert("insert into TEACHER values(#{id},#{name})")
    int insTeacher(Teacher teacher);

    @Update("update TEACHER set name=#{name} where id=#{id}")
    int updTeacher(Teacher teacher);

    @Delete("delete from TEACHER where id=#{0}")
    int delById(int id);

    @Results(value={
                   @Result(id=true,property ="id",column="id"),
                   @Result(property = "name" ,column = "name"),
                   @Result(property = "list" ,column = "id",many =@Many(select="com.Annotation.mapper.StudentMapper.selById"))
                    })
    @Select("select * from TEACHER")
    List<Teacher> selTeacher();

}
