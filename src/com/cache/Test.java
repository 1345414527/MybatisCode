package com.cache;

import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {

    public static void main(String[] args) throws IOException {
            InputStream is=null;
            is= Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session=factory.openSession();

        }
}
