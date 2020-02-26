package com.opensessioninview.Utils;

import com.log4j.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    //factory实例化是一个比较耗时费性能的过程
    //保证只有一个factory
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> tl=new ThreadLocal<>();
    static{
        try {
            InputStream is= Resources.getResourceAsStream("mybatis.xml");
            factory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取SqlSession的方法
     */
    public static SqlSession getSession(){
        SqlSession session=tl.get();
        if(session==null) {
           session = factory.openSession();
        }
        tl.set(session);
        return tl.get();

    }

    public static void closeSession(){
        SqlSession session=tl.get();
        if(session!=null){
            session.close();
        }
        tl.set(null);
    }


}
