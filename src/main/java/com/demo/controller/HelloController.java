package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author litinglan 2019/4/12 14:04
 */
@Controller
public class HelloController {

    @RequestMapping
    public void load(String[] args) throws ClassNotFoundException {
        //ClassLoader：根装载器（jre下的类库，c++实现，在java访问不到）、ExtClassLoader（jre的ext扩展类包）、APPClassLoader（classpath下类包）
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class<?> aClass1 = contextClassLoader.loadClass("");
    }

    public void func() {
        System.out.println("--------inv func--------");
    }
}
