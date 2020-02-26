package com.resultmap;

import com.student.pojo.Student;
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
        try {
            is= Resources.getResourceAsStream("com/resultmap/mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();

        List<Student>  list=session.selectList("com.resultmap.mapper.StudentMapper.selAll");
        System.out.println(list);

        session.close();
        System.out.println("程序执行结束");
    }

}
