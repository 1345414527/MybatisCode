package com.IntefaceBinding.mapper;

import com.IntefaceBinding.pojo.Log;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapper {
    List<Log> selAll();

    /**
     * mybatis把参数转换为map了,其中@Param("key")，参数内容就是map的value
     * @param accin
     * @param accout
     * @return
     */

    //List<Log> selByAccInAccount(String accin,String account)   对应的用#{0}和#{1}来接收
    List<Log> selByAccInAccount(@Param("accin")String accin,@Param("accout")String accout);

    int upd(Log log);

    List<Log> selByLog(Log log);

    List<Log> selIn(List<Integer> list);

    int ins(List<Log> list);

}
