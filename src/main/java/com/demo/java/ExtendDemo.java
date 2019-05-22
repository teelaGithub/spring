package com.demo.java;

import java.util.*;

/**
 * @author litinglan 2019/5/16 11:44
 */
public class ExtendDemo {
    public static String c = "ccc";

    static {
        System.out.println("super static block===" + c);
    }

    public ExtendDemo() {
        System.out.println("super constr method");
    }

    protected int t() {
        return 2;
    }

    public static void main(String[] args) {
//        System.out.println(JuniorDemo.c);

        Random random = new Random(); // 创建随机数生成器
        List list = new ArrayList();// 生成10 个随机数，并放在集合list 中
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1000));
            System.out.println("ran: " + list.get(i));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i));
        }
        // 对集合中的元素进行排序
        Iterator it = list.iterator();
        int count = 0;
        while (it.hasNext()) {
            // 顺序输出排序后集合中的元素
            System.out.println(++count + ": " + it.next());
        }
    }
}

class JuniorDemo extends ExtendDemo {
//    public static  String c = "ccc";

    static {
        System.out.println("junior static block====" + c);
    }

    public int t() {
        return 1;
    }

    public JuniorDemo() {
        System.out.println("junior constr method");
    }
}