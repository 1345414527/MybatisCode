package com.bank.servlet;

import com.bank.Service.AccountService;
import com.bank.Service.impl.AccountServiceImpl;
import com.bank.pojo.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletTransferServlet")
public class ServletTransferServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account accOut=new Account();
        Account accIn=new Account();
        accOut.setAccNo(req.getParameter("accOutAccNo"));
        accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassward")));
        accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
        accIn.setName(req.getParameter("accInName"));
        accIn.setAccNo(req.getParameter("accInAccNo"));
        int state=accountService.transfer(accIn,accOut);
        if(state==AccountService.OK){
            //成功
            resp.sendRedirect("/Mybatis/bank/log.jsp");
        }else{
            //失败
            HttpSession session=req.getSession();
            session.setAttribute("code",state);
            System.out.println(state);
            resp.sendRedirect("/Mybatis/bank/error.jsp");
        }

    }
}
