package com.bjsxt.service.impl;

import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PeopleServiceImpl implements PeopleService {

    @Override
    public List<People> show() {
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
        List<People> list=session.selectList("com.bjsxt.mapper.PeopleMapper.selAll");
        session.close();
        return list;
    }
}
