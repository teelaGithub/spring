package com.demo.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author litinglan 2019/4/12 11:06
 */
@Aspect
@Component
public class AopDemo {

    @Pointcut("execution(* com.demo.controller..*.*(..))")
    public void point() {

    }

    @Before("point()")
    public void before() {
        System.out.println("--------before method--------");
    }

    @AfterReturning("point()")
    public void afterReturning() {
        System.out.println("--------afterReturning method--------");
    }

    //final增强，总会执行，一般用于释放资源等（finally）
    @After("point()")
    public void after() {
        System.out.println("--------after method--------");
    }

}
