package com.Test.service;

import com.Test.mapper.ControlClass;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.misc.Resource;

import java.io.IOException;
import java.io.InputStream;

public class Service {
    public static void main(String[] args) {
        InputStream is=null;
        try {
            is= Resources.getResourceAsStream("com/Test/mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ControlClass controlClass=sqlSession.getMapper(ControlClass.class);
        int result=controlClass.insertStu(1,"ะกอ๕",1);
        System.out.println(result);



    }
}
