package com.demo.spring.aop;

import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理
 * 注：对类创建子类的方式进行动态代理，不能代理final或private方法
 *    代理对象性能较高，但创建代理对象花费时间较多
 *    适用于创建单例的代理对象或有实例池的代理
 *
 * @author litinglan 2019/4/25 14:41
 */
public class CglibProxy implements MethodInterceptor {
    private Logger logger = Logger.getLogger(CglibProxy.class);
    private Enhancer enhancer = new Enhancer();

    /**
     * 创建动态代理对象
     *
     * @param clazz
     * @return
     */
    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);//设置需要代理创建资料的目标基类
        enhancer.setCallback(this);
        return enhancer.create();//通过字节码技术动态创建子类实例
    }

    /**
     * 拦截目标类方法调用，并植入横切逻辑
     *
     * @param o           目标类实例
     * @param method      目标类方法的反射对象
     * @param objects     方法入参
     * @param methodProxy 代理类实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //横切逻辑
        logger.info("-----before------" + o.getClass().getName());
        //通过代理类调用目标父类方法
        Object result = methodProxy.invokeSuper(o, objects);
        //横切逻辑
        logger.info("-----after------" + o.getClass().getName());
        return result;
    }

    public static void main(String[] args) {
        //通过动态创建子类的方式创建代理类
        CglibProxy cglibProxy = new CglibProxy();
        UserService userService = (UserService) cglibProxy.getProxy(UserServiceImpl.class);
        userService.getByName("jack");
    }
}
