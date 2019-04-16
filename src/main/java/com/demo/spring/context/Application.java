package com.demo.spring.context;


import com.demo.aop.AopDemo;
import com.demo.config.ApplicationConfig;
import com.demo.controller.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author litinglan 2019/4/12 10:36
 */
public class Application {
    public static void main(String[] args) {

        //AnnotationConfigApplicationContext基于注解类配置的ApplicationContext实现类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        //ClassPathXmlApplicationContext基于xml配置的ApplicationContext实现类
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("");
        Hello hello = applicationContext.getBean(Hello.class);
        AopDemo aopDemo = applicationContext.getBean(AopDemo.class);
        hello.func();
        System.out.println(aopDemo);
    }
}
