package com.demo.java;

/**
 * @author litinglan 2019/5/15 16:07
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        //ClassLoader：根装载器（jre下的类库，c++实现，在java访问不到）、ExtClassLoader（jre的ext扩展类包）、APPClassLoader（classpath下类包）
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Class<?> aClass1 = contextClassLoader.loadClass("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
