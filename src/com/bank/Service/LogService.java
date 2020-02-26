package com.bank.Service;

import com.bank.pojo.PageInfo;

public interface LogService {
    /**
     * 分页显示
     * @param pageSize
     * @param pageNumber
     * @return
     */
    PageInfo showPage(int pageSize,int pageNumber);
}
