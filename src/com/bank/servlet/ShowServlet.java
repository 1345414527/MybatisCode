package com.bank.servlet;

import com.bank.Service.LogService;
import com.bank.Service.impl.LogServiceImpl;
import com.bank.pojo.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/ShowServlet")
public class ShowServlet extends HttpServlet {
    private LogService logService=new LogServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //获取pageNumber
        String pageNumberStr=req.getParameter("pageNumber");
        int pageNumber=1;
        if(pageNumberStr!=null||!pageNumberStr.equals("")){
                 pageNumber= Integer.parseInt(pageNumberStr);
        }

        //获取pageSize
        String pageSizeStr=req.getParameter("pageSize");
        int pageSize=0;
        if(pageSizeStr!=null||!pageSizeStr.equals("")){
            pageSize=Integer.parseInt(pageNumberStr);
        }
        PageInfo pi=logService.showPage(pageSize,pageNumber);
        req.setAttribute("pageInfo",pi);
        resp.sendRedirect("/Mybatis/bank/log.jsp");


    }
}
