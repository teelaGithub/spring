package com.demo.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化资源
 *
 * @author litinglan 2019/4/18 17:03
 */
public class ResI18n {
    //java方式加载国际化资源文件
    public static void javaI18n() {
        //加载resource_zh_CN.properties
        //Locale本地化对象
        ResourceBundle resource = ResourceBundle.getBundle("resource", Locale.CHINA);
        //加载resource_en_US.properties
        ResourceBundle resource1 = ResourceBundle.getBundle("resource", Locale.US);
        //资源文件可格式化动态设置
        MessageFormat messageFormat = new MessageFormat(resource.getString("welcome"), Locale.CHINA);
        String jack = messageFormat.format(new Object[]{"jack"});
        System.out.println(jack);
    }

    //spring框架加载国际化文件：MessageSource
    public static void springI18n() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        MessageSource messageSource = (MessageSource) applicationContext.getBean("messageSource");
        String message = messageSource.getMessage("welcome", new Object[]{"jack"}, Locale.CHINA);
        System.out.println(message);
    }
}
