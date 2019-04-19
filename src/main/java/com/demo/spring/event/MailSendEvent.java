package com.demo.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * 发送邮件事件
 *
 * @author litinglan 2019/4/19 14:51
 */
public class MailSendEvent extends ApplicationContextEvent {
    private String to;

    public MailSendEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }

    public String getTo() {
        return to;
    }
}
