package com.demo.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * 方法替换
 * 实现接口MethodReplacer#reimplement并配置即可替换指定方法的实现过程
 * @author litinglan 2019/4/17 15:19
 */
public class CarMethodReplace implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return null;
    }
}
