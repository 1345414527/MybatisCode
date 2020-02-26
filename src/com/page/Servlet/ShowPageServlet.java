package com.page.Servlet;

import com.page.Service.impl.PeopleService;
import com.page.pojo.PageInfo;
import com.page.pojo.People;
import org.apache.ibatis.type.IntegerTypeHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ShowPageServlet")
public class ShowPageServlet extends HttpServlet {
    private static PeopleService people=new PeopleService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");


        //第一次访问的验证,如果没有传递参数,设置默认值
        String pageSizeStr=req.getParameter("pageSize");
        int pageSize=2;
        if(pageSizeStr!=null&&!pageSizeStr.equals("")){
            pageSize=Integer.parseInt(pageSizeStr);

        }

        String pageNumberStr=req.getParameter("pageNumber");
        int pageNumber=0;
        if(pageNumberStr!=null&&!pageNumberStr.equals("")){
            pageNumber= Integer.parseInt(pageNumberStr);
        }
        PageInfo pi=people.showPage(pageSize,pageNumber);
        req.setAttribute("pageInfo",pi);
        resp.sendRedirect("/test/show.jsp");

    }
}
