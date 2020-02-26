package com.Automapping;

import com.resultmap2.pojo.Teacher;
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
            is= Resources.getResourceAsStream("com/resultmap2/mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();

        List<Teacher>  list=session.selectList("com.resultmap2.mapper.TeacherMap.selAll1");
        for(Teacher teacher:list){
            System.out.println(teacher);
        }

        session.close();
        System.out.println("程序执行结束");
    }

}
