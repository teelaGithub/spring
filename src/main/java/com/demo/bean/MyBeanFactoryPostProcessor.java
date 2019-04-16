package com.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 工厂后处理器
 * 所有<bean>解析成BeanDefinition后，ApplicationContext调用工厂后处理器的方法
 * 注：通过<bean>或注解可将这些后处理器注册到容器中，不像BeanFactory需手动注册到容器中
 * @author litinglan 2019/4/16 15:51
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    //通过此方法对定义的bean做一些处理
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("car");
        bd.getPropertyValues().addPropertyValue("carName","test");
    }
}
