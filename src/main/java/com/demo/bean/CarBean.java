package com.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author litinglan 2019/4/16 14:30
 */
public class CarBean implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String carName;
    private int brand;

    private BeanFactory beanFactory;
    private String beanName;

    public CarBean() {
        System.out.println("invoice Car#construct");
    }

    public void setCarName(String carName) {
        System.out.println("invoice Car#setCarName====" + carName);
        this.carName = carName;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    //通过<bean>节点的init-method调用
    public void myInit() {
        System.out.println("invoice Car#myInit");
    }

    //通过<bean>节点的destroy-method调用
    public void myDestroy() {
        System.out.println("invoice Car#myDestroy");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("override BeanFactoryAware#setBeanFactory====" + beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("override BeanNameAware#setBeanName====" + s);
        this.beanName = s;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("override DisposableBean#destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("override InitializingBean#afterPropertiesSet");
    }
}
