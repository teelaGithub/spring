package com.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @After("point()")
    public void after() {
        System.out.println("--------after method--------");
    }

}
