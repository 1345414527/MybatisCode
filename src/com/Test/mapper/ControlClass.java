package com.Test.mapper;

import org.apache.ibatis.annotations.Param;

public interface ControlClass{
    
    public int insertStu(@Param("cno") int cno, @Param("cname") String cname, @Param("cdesc") int cdesc);
    
}
