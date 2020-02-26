package com.bank.Service.impl;

import com.bank.Service.LogService;
import com.bank.pojo.Log;
import com.bank.pojo.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogServiceImpl implements LogService {
    @Override
    public PageInfo showPage(int pageSize, int pageNumber) {
        InputStream is=null;
        try {
            is= Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        Map<String,Integer> map=new HashMap<>();
        map.put("pageStart",(pageNumber-1)*pageSize);
        map.put("pageEnd",pageNumber*pageSize);
        List<Log> list=session.selectList("com.bank.mapper.LogMapper.selByPage",map);
        long total=session.selectOne("com.bank.mapper.LogMapper.selCount",map);
        PageInfo pi=new PageInfo();
        pi.setList(list);
        pi.setPageNumber(pageNumber);
        pi.setPageSize(pageSize);
        pi.setTotal(total%pageSize==0?total/pageSize:total/pageSize+1);
        session.close();
        return pi;

    }
}
