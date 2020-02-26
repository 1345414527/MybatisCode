package com.bjsxt.mapper;

import com.bjsxt.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        InputStream io=null;
        try {
            io= Resources.getResourceAsStream("com/bjsxt/mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //工厂模式 构建者设计模式
        //构建者设计模式存在的意义:简化对象实例化过程
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(io);
        SqlSession session=factory.openSession();
        Map<String,Integer> map=new HashMap<>();
        int size=5;
        int num=2;
        map.put("pageStart",size*(num-1));
        map.put("pageEnd",size*num);
        List<People> list=session.selectList("com.bjsxt.mapper.PeopleMapper.page",map);
        for (People people:list){
            System.out.println(people);
        }

        People people=new People();
        people.setId(14);
        people.setName("王五");
        people.setAge(20);
        try {
            int index = session.insert("com.bjsxt.mapper.PeopleMapper.ins", people);
            if (index > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        }catch (Exception e){
            session.rollback();
        }
        session.commit();
        session.close();

        }


}
