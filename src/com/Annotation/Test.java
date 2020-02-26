package com.Annotation;

import com.Annotation.mapper.StudentMapper;
import com.Annotation.mapper.TeacherMapper;
import com.Annotation.pojo.Student;
import com.Annotation.pojo.Teacher;
import com.student.service.StudentService;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        InputStream is=null;
        SqlSession session=null;
        try {
            is= Resources.getResourceAsStream("com/Annotation/mybatis.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            session=factory.openSession();
            TeacherMapper tm=session.getMapper(TeacherMapper.class);
            StudentMapper sm=session.getMapper(StudentMapper.class);

            //查询
//            List<Teacher> list1=tm.selAll();
//            for(Teacher t:list1){
//                System.out.println("id-->"+t.getId()+"   name-->"+t.getName());
//            }

            //增加
//            Teacher teacher=new Teacher();
//            teacher.setId(4);
//            teacher.setName("老师四");
//            int result=tm.insTeacher(teacher);
//            System.out.println(result);

            //修改
//            Teacher teacher=new Teacher();
//            teacher.setId(4);
//            teacher.setName("苍老师");
//            int result=tm.updTeacher(teacher);

            //删除
//            int result=tm.delById(4);
//            System.out.println(result);

            //查询
//            List<Student> list1=sm.selAll();
//            for(Student student:list1){
//                System.out.println(student);
//            }

            //联合查询
            List<Teacher> list=tm.selTeacher();
            System.out.println(list);



            session.commit();
        } catch (IOException e) {
            session.rollback();
            e.printStackTrace();
        }

    }
}
