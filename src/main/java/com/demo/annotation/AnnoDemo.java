package com.demo.annotation;

import java.lang.annotation.*;

/**
 * @author litinglan 2019/4/12 11:38
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@Documented
public @interface AnnoDemo {
//    注解类属性定义
    String value() default "";
}
