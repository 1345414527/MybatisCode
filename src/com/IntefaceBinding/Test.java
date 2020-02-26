package com.IntefaceBinding;

import com.IntefaceBinding.mapper.LogMapper;
import com.IntefaceBinding.pojo.Log;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        InputStream is=null;
        try {
            is= Resources.getResourceAsStream("com/IntefaceBinding/mybatis.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession session=factory.openSession();
            /**
             * 接口，为什么能实例化
             *需要给接口一个实例化对象
             * 使用JDBC的动态代理设计模式
             * 面向接口的代理设计模式
             */
            LogMapper logMapper=session.getMapper(LogMapper.class);

            Scanner scanner=new Scanner(System.in);
            System.out.println("请输入转账账号:");
            String accin=scanner.nextLine();
            System.out.println("请输入收款账号:");
            String accout=scanner.nextLine();
            System.out.println("请输入ID");
            int id=scanner.nextInt();


            List<Log> list=logMapper.selAll();
            for(Log log:list){
                System.out.println(log.getAccin()+"-"+log.getId());
            }

            List<Log> list1= logMapper.selByAccInAccount(accin,accout);
            for(Log log:list1){
                    System.out.println(log);
            }

            Log log=new Log();
            log.setId(id);
            log.setAccin(accin);
            log.setAccout(accout);
            int count=logMapper.upd(log);
            System.out.println(count);

            List<Integer> list3=new ArrayList();
            list3.add(1);
            list3.add(2);
            list3.add(3);
            List<Log> list2=logMapper.selIn(list3);
            System.out.println(list2.get(1)+"---"+list2.get(2));




            List<Log> list4=new ArrayList<>();
            for(int i=4;i<10;i++){
                Log log1=new Log();
                log1.setId(i);
                log1.setAccin(i+"");
                log1.setAccout((i+1)+"");
                list4.add(log1);
            }
            int index=logMapper.ins(list4);
            System.out.println(index);

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
