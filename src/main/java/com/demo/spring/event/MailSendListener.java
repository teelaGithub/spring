package com.demo.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * 事件监听器
 * 注：spring容器启动时初始化应用上下文事件广播器，后注册事件监听器（添加到广播器中的监听器注册表中），发布事件后触发监听器
 *
 * @author litinglan 2019/4/19 14:56
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        System.out.println("MailSendEvent向" + event.getTo() + "发送完一封邮件");
    }
}
