package com.bank.Service;

import com.bank.pojo.Account;

public interface AccountService {
    /**
     * 账号和密码不匹配的状态码
     */
    int ACCOUNT_PASSWD_NOT_MATCH=1;

    /**
     * 余额不足
     */
    int ACCOUNT_BALANCE_NOT_ENOUGH=2;

    /**
     * 账户和姓名不匹配
     */
    int ACCOUNT_NAME_ACCNO_NOT_CATCH=3;

    /**
     * 转账失败
     */
    int error=4;

    /**
     * 转账成功
     */
    int OK=5;

    /**
     * 转账
     * @param accIn 收款账户
     * @param accOut 转账账户
     * @return
     */
    int transfer(Account accIn,Account accOut);



}
