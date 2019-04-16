package com.demo.spring.resource;

import org.springframework.core.io.*;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.context.support.ServletContextResource;

import java.net.MalformedURLException;

/**
 * @author litinglan 2019/4/16 16:08
 */
public class BeanResource {
    public static void main(String[] args) throws MalformedURLException {
        //加载资源
        //①PathMatchingResourcePatternResolver#getResource根据资源类型前缀加载资源，不需指定具体资源加载实现类
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = patternResolver.getResource("classpath:beans.xml");

        //②通过指定具体资源实现类加载资源
        ClassPathResource resource1 = new ClassPathResource("com/bean.xml");
        Resource resource2 = new PathResource("");//classpath:、file:、http://、ftp://
        Resource resource3 = new UrlResource("");//file:、http://、ftp://
        WritableResource resource4 = new FileSystemResource("D:/bean.xml");//WritableResource可写资源接口
        Resource resource5 = new ServletContextResource(null, "WEB-INF/bean.xml");

        //EncodedResource对资源进行编码
        EncodedResource encodedResource = new EncodedResource(resource, "utf-8");
    }
}
