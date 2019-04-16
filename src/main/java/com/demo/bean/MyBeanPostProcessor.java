package com.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean后处理器
 * 扩展BeanPostProcessor后处理器，在初始化init前后进行一些操作
 * @author litinglan 2019/4/16 14:50
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            System.out.println("BeanPostProcessor#postProcessBeforeInitialization");
            CarBean car = (CarBean) bean;
            car.setCarName("bbbbb");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            System.out.println("BeanPostProcessor#postProcessAfterInitialization");
            CarBean car = (CarBean) bean;
            car.setCarName("aaaaa");
        }
        return bean;
    }
}
