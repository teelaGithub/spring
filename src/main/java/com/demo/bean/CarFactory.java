package com.demo.bean;

/**
 * 工厂方法注入
 * 1、构造函数注入 2、属性注入 3、工厂方法注入
 * @author litinglan 2019/4/17 15:24
 */
public class CarFactory {

    //非静态工厂方法，需实例化后
    public CarBean getCar(){
        CarBean carBean=new CarBean();
        carBean.setCarName("奔驰");
        return carBean;
    }

    //静态工厂方法，可直接调用
    public static CarBean createCar(){
        CarBean carBean=new CarBean();
        carBean.setCarName("奔驰");
        return carBean;
    }
}
