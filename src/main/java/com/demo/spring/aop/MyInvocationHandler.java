package com.demo.spring.aop;

import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理：Proxy、InvocationHandler
 * 实现InvocationHandler接口，定义横切逻辑，并通过反射机制调用目标类的方法，动态将横切逻辑与业务逻辑组合一起
 * 注：只能为接口创建代理实例，代理对象的性能比cglib差，但创建代理对象的速度比cglib快
 *
 * @author litinglan 2019/4/19 17:20
 */
public class MyInvocationHandler implements InvocationHandler {
    //目标类
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  是最终生成的代理实例，一般不用
     * @param method 被代理目标类的方法
     * @param args   被代理目标类方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法调用前执行一些逻辑代码
        System.out.println("...方法调用前执行一些逻辑代码");
        Object invoke = method.invoke(target, args);//通过反射机制调用目标类的方法
        //方法调用后执行一些逻辑代码
        System.out.println("方法调用后执行一些逻辑代码...");
        return invoke;
    }

    public static void main(String[] args) {
        //希望被代理的目标类
        UserService userService = new UserServiceImpl();
        //将目标类的业务逻辑和横切逻辑结合
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);
        //创建代理实例（针对接口，若换成UserServiceImpl则抛异常）
        UserService proxyUserService = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), myInvocationHandler);
        //调用
        proxyUserService.getByName("proxy");
    }
}
