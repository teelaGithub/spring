package com.demo.service.impl;

import com.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author litinglan 2019/4/15 10:38
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    @Transactional
    public String getByName(String name) {
        System.out.println("执行业务代码");
        return name;
    }

    public static void main(String[] args) {
        //获取带有泛型的直接父类
        //Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型
        Type genericSuperclass = UserServiceImpl.class.getGenericSuperclass();
        System.out.println(genericSuperclass);
        //ParameterizedType参数化类型，即泛型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println((Class)actualTypeArguments[0]);
    }
}
