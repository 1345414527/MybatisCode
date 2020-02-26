package com.bjsxt.servlet;

import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;
import com.bjsxt.service.impl.PeopleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//大部分注解都有默认属性,如果注解中只给默认属性赋值,可以省略属性名
//否则在注解的(属性名=属性值)格式
@WebServlet(urlPatterns = {"/com/bjsxt/servlet/ShowServlet"})
public class ShowServlet extends HttpServlet {
   private static PeopleService peopleService=new PeopleServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<People> list=peopleService.show();
        System.out.println(list.size());
        req.setAttribute("list",list);
        //相对路径
        //只要路径中以/开头都叫做全路径,从路径根目录出发找到其他资源的过程
        //只要不以/开头都是相对路径,相对路径是从当前资源出发找到其他资源的过程
        //如果请求转发
        req.getRequestDispatcher("/test/index.jsp").forward(req,resp);
    }




}
