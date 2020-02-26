package com.bank.Service.impl;

import com.bank.Service.AccountService;
import com.bank.pojo.Log;
import com.bank.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;

public class AccountServiceImpl implements AccountService {

    @Override
    public int transfer(Account accIn, Account accOut) {
        InputStream is=null;
        SqlSession session=null;
        try {
            is=Resources.getResourceAsStream("com/bank/mybatis.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            session=factory.openSession();
            //先判断账户和密码是否匹配
            Account accountOutSelect=session.selectOne("com.bank.mapper.AccountMapper.selByAccountPwd",accOut);
            if(accountOutSelect!=null){
                 if(accountOutSelect.getBalance()>=accOut.getBalance()){
                     Account accountInSelect=session.selectOne("com.bank.mapper.AccountMapper.selByAccountName",accIn);
                     if(accountInSelect!=null){
                         accIn.setBalance(+accOut.getBalance());
                         accOut.setBalance(-accOut.getBalance());
                          int index=session.update("com.bank.mapper.AccountMapper.updBalanceByaccno",accOut);
                          index+=session.update("com.bank.mapper.AccountMapper.updBalanceByaccno",accIn);
                          if(index==2){
                              //转账成功
                              Log log=new Log();
                              log.setAccin(accIn.getAccNo());
                              log.setAccout(accOut.getAccNo());
                              log.setMoney(accIn.getBalance());
                              session.insert("com.bank.mapper.LogMapper.insLog",log);
                              Logger logger=Logger.getLogger(AccountServiceImpl.class);
                              logger.info(log.getAccout()+"给"+log.getAccin()+"在"+ Instant.now()+"转了"+log.getMoney());
                              session.commit();
                              session.close();
                              return OK;
                          }else{
                              //转账失败
                              session.rollback();
                              session.close();
                              return error;
                          }
                     }else{
                          //账户与姓名不匹配
                         return ACCOUNT_NAME_ACCNO_NOT_CATCH;
                     }
                 }else{
                     //余额不足
                     return ACCOUNT_BALANCE_NOT_ENOUGH;
                 }
            }else{
                  //账户和密码不匹配
                return ACCOUNT_PASSWD_NOT_MATCH;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return error;

        }

    }
}
