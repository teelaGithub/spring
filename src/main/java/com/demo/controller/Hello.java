package com.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author litinglan 2019/4/12 14:04
 */
@Component
public class Hello {
    public void log() {
//        1、log4j
        Logger logger = Logger.getLogger(Hello.class);
//        2、common-logging + log4j
//        3、common-logging + slf4j + log4j，使用common-logging接口，slf4j决定底层实现用哪种日志
        Log log = LogFactory.getLog(Hello.class);
//        4、slf4j + log4j，slf4j不用判断日志level，会自动判断并输出level
//        Logger logger = LoggerFactory.getLogger(Hello.class);
        log.info("test log4j", new Exception());
    }

    public static void main(String[] args) {
        //ClassLoader：根装载器（jre下的类库，c++实现，在java访问不到）、ExtClassLoader（jre的ext扩展类包）、APPClassLoader（classpath下类包）
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        Class<?> aClass1 = contextClassLoader.loadClass("");
    }

    public void func() {
        System.out.println("--------inv func--------");
    }
}
