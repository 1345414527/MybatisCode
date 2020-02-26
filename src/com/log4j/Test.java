package com.log4j;


import org.apache.log4j.Logger;

public class Test {
    public static void main(String[] args) {
        Logger logger= Logger.getLogger(Test.class);
        logger.debug("这是一个调试信息");
        logger.info("这是一个普通信息");
        logger.warn("这是一个警告信息");
    }
}
