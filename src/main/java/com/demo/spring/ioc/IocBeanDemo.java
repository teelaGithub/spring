package com.demo.spring.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @author litinglan 2019/4/15 17:23
 */
public class IocBeanDemo {
    public static void main(String[] args) {
        //加载资源
        //①PathMatchingResourcePatternResolver#getResource根据资源类型前缀加载资源，不需指定具体资源加载实现类
        //②通过指定具体资源实现类加载资源，如实现类ClassPathResource
//        ClassPathResource classPathResource = new ClassPathResource("");
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = patternResolver.getResource("classpath:beans.xml");

        //XmlBeanDefinitionReader通过Resource装载spring配置信息并启动IOC容器
        //此时并未实例化Bean
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        //启动IOC容器后才能getBean获取Bean
        //第一次访问Bean时才实例化Bean
        Object bean = beanFactory.getBean("");
    }
}
