package com.jiang.test;

import com.jiang.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


public class Test {
    public static void main(String[] args) {
        InputStream is=null;
        try {
            is=Resources.getResourceAsStream("com/jiang/Mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //使用工厂设计模式
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        //生产SqlSession
        SqlSession session=factory.openSession();
        //返回值多个
        List<Flower> list=session.selectList("a.b.selAll");
        int size=list.size();
        for(Flower flower:list){
            System.out.println(flower.toString());
        }

        //返回值一个
        int count=session.selectOne("a.b.selById");
        System.out.println("count="+count);

        Map<Object,Object> map=session.selectMap("a.b.c","name");
        for(Object flowers:map.keySet()){
            System.out.println((String)flowers+map.get(flowers));
        }

        Map<Object,Map<Object,Object>> map1=session.selectMap("a.b.cc","name");
        for(Object key:map1.keySet()){
            System.out.println((String)key+map1.get((String)key));
        }
        session.close();

    }
}

