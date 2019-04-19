package com.demo.config;

import com.demo.bean.CarBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author litinglan 2019/4/12 10:38
 */
@Configuration
@ComponentScan(basePackages = "com.demo")
@EnableAspectJAutoProxy
public class ApplicationConfig {

    @Bean(initMethod = "myInit",destroyMethod = "myDestroy")
    public CarBean carBean(){
        CarBean car = new CarBean();
        car.setCarName("11111");
        return car;
    }

}
