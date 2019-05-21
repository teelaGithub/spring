package com.demo.java;

import java.util.concurrent.Executors;

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
        System.out.println(JuniorDemo.c);
        System.out.println(new JuniorDemo().hashCode());
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