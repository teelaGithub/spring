package com.demo.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 实现ApplicationContextAware接口，获取容器实例以便发布事件
 * @author litinglan 2019/4/19 15:00
 */
public class MailSend implements ApplicationContextAware {
    private ApplicationContext context;

    //容器启动时注入容器实例
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void sendMail(String to){
        System.out.println("MailSend：模拟邮件发送...");
        MailSendEvent event=new MailSendEvent(context,to);
        //向容器中所有事件监听器发送事件
        context.publishEvent(event);
    }
}
