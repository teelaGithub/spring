package com.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Bean后处理器
 * 扩展InstantiationAwareBeanPostProcessor后处理器，在bean实例化前后进行一些操作
 * @author litinglan 2019/4/16 14:42
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    //实例化bean前调用
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation");
        }
        return null;
    }

    //实例化bean后调用
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation");
        }
        return true;
    }

    //设置属性值前时调用
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor#postProcessPropertyValues");
        }
        return pvs;
    }

}
