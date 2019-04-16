package com.demo.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

/**
 * @author litinglan 2019/4/16 15:12
 */
public class BeanLifeCycle {
    public static void lifeCycleBeanFactory(){
        //加载资源文件并启动BeanFactory容器
        Resource resource=new PathResource("file:com.demo.config/ApplicationConfig");//有待确定是否可用
        BeanFactory beanFactory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader((DefaultListableBeanFactory)beanFactory);
        reader.loadBeanDefinitions(resource);

        //向容器中注册MyBeanPostProcessor后处理器
        //addBeanPostProcessor()在ConfigurableBeanFactory中
        ((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
        //向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //单例：第一次获取bean时将触发bean生命周期方法的调用，后续则直接从容器缓存池中获取
        CarBean car = (CarBean) beanFactory.getBean("car");

        //关闭容器
        ((DefaultListableBeanFactory)beanFactory).destroySingletons();
    }

    public static void main(String[] args) {
        BeanLifeCycle.lifeCycleBeanFactory();
    }
}
