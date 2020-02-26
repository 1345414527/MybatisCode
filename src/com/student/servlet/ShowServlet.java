package com.student.servlet;

import com.student.pojo.PageInfo;
import com.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ShowServlet")
public class ShowServlet extends HttpServlet {
    private StudentServiceImpl studentService=new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String sname=req.getParameter("sname");
        if(sname!=null&&!sname.equals(""))
            sname=new String(sname.getBytes("iso-8859-1"),"utf-8");
        String tname=req.getParameter("tname");
        if(tname!=null&&!tname.equals(""))
            tname=new String(tname.getBytes("iso-8859-1"),"utf-8");
        String pageSize=req.getParameter("pageSize");
        String pageNumber=req.getParameter("pageNumber");
        PageInfo pi=studentService.showPageInfo(sname,tname,pageSize,pageNumber);
        req.setAttribute("pageInfo",pi);
        resp.sendRedirect("/Mybatis/student/index.jsp");
    }
}
