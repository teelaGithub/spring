package com.demo.bean;

import java.beans.PropertyEditorSupport;

/**
 * PropertyEditor：JavaBean的属性编辑器（类型转换器）
 * 注：一般扩展PropertyEditorSupport，而不是实现PropertyEditor接口
 * java基本类型以包装类执行
 *
 * @author litinglan 2019/4/18 13:54
 */
public class BrandPropertyEditor extends PropertyEditorSupport {
    private static String[] options = {"A", "B", "C"};

    //外部属性编辑器以下拉方式展示
    public String[] getTags() {
        return options;
    }

    //属性初始值
    public String getJavaInitializationString() {
        return "" + this.getValue();
    }

    //将内部属性值int转换对应的字符串形式，供外部编辑器展示
    public String getAsText() {
        int var1 = (Integer) this.getValue();
        return options[var1];
    }

    //将外部设置的字符转换为内部值
    public void setAsText(String var1) throws IllegalArgumentException {
        for (int i = 0; i < options.length; i++) {
            if (options[i].equals(var1)) {
                setValue(i);//设置属性值
                return;
            }
        }
    }

}
