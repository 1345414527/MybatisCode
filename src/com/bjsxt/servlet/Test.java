package com.bjsxt.servlet;

import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;
import com.bjsxt.service.impl.PeopleServiceImpl;

import java.util.List;

public class Test {

        public static void main(String[] args) {
            PeopleService peopleService=new PeopleServiceImpl();
            List<People> list=peopleService.show();
            System.out.println(list.size());
        }


}
