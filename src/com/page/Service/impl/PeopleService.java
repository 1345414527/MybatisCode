package com.page.Service.impl;

import com.page.pojo.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class PeopleService implements com.page.Service.PeopleService {
    @Override
    public PageInfo showPage(int pageSize, int pageNumber) {
        InputStream is=null;
        try {
            is= Resources.getResourceAsStream("com/page/mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        Map<String,Object> map=new HashMap<>();
        map.put("startPage",(pageNumber-1)*pageSize);
        map.put("pageSize",pageNumber*pageSize);

        //设置page信息
        PageInfo pi=new PageInfo();
        pi.setPageNumber(pageNumber);
        pi.setPageSize(pageSize);
        pi.setList(session.selectList("com.page.mapper.PeopleManager.selByPage",map));
        int total=session.selectOne("com.page.mapper.PeopleManager.selCount");
        pi.setTotal(total%pageSize==0? total/pageSize:total/pageSize+1);

        return pi;
    }


}
