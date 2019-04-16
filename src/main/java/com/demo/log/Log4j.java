package com.demo.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

/**
 * @author litinglan 2019/4/16 16:40
 */
public class Log4j {
    public static void main(String[] args) {
//        1、log4j
        Logger logger = Logger.getLogger(Log4j.class);
//        2、common-logging + log4j
//        3、common-logging + slf4j + log4j，使用common-logging接口，slf4j决定底层实现用哪种日志
        Log log = LogFactory.getLog(Log4j.class);
//        4、slf4j + log4j，slf4j不用判断日志level，会自动判断并输出level
//        Logger logger = LoggerFactory.getLogger(Hello.class);
        log.info("test log4j", new Exception());
    }
}
