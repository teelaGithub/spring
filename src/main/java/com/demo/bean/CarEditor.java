package com.demo.bean;

import java.beans.PropertyEditorSupport;

/**
 * spring属性编辑器
 * 注：因不需提供UI界面，故只需重写PropertyEditorSupport#setAsText即可
 * 还需在配置文件中配置将自定义属性编辑器注入spring容器
 *
 * @author litinglan 2019/4/18 14:48
 */
public class CarEditor extends PropertyEditorSupport {

    //将配置文件中设置的字符串处理成属性类型对象
    public void setAsText(String var1) throws IllegalArgumentException {
        String[] split = var1.split(",");
        CarBean carBean = new CarBean();
        carBean.setCarName(split[0]);
        setValue(carBean);//设置属性值
    }
}
