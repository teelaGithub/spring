package com.demo.bean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * BeanInfo描述JavaBean的哪些属性可以编辑及对应的编辑器，每个属性对应一个属性描述器PropertyDescriptor
 * 注：命名JavaBean名+BeanInfo，设置好后可在TextField组件中进行可视化（有界面）操作
 * @author litinglan 2019/4/18 14:17
 */
public class CarBeanBeanInfo extends SimpleBeanInfo {
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            //将BrandPropertyEditor绑定到CarBean的属性brand
            PropertyDescriptor breadPropertyDescriptor = new PropertyDescriptor("brand", CarBean.class);
            breadPropertyDescriptor.setPropertyEditorClass(BrandPropertyEditor.class);

            return new PropertyDescriptor[]{breadPropertyDescriptor};
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }

}
