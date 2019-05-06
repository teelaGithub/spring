package com.demo.thread;

/**
 * ThreadLocal保存线程本地变量的容器，为每个使用多线程变量的线程分配一个独立的变量副本；
 * ThreadLocal有一Map，存储每个线程的变量副本，键是线程对象，值是对应线程的变量副本
 * InheritableThreadLocal继承于ThreadLocal,它自动为子线程复制一份从父线程那里继承来的变量
 *
 * @author litinglan 2019/5/6 15:48
 */
public class MyThreadLocal {

    //匿名内部类覆盖ThreadLocal#initialValue方法，设置初始值
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        threadLocal.set(threadLocal.get() + 1);
        return threadLocal.get();
    }

    public static void main(String[] args) {
        //多线程下，每个线程的变量都互不干扰
        MyThreadLocal local = new MyThreadLocal();
        ThreadTest test = new ThreadTest(local);
        ThreadTest test1 = new ThreadTest(local);
        ThreadTest test2 = new ThreadTest(local);
        test.start();
        test1.start();
        test2.start();
    }

    private static class ThreadTest extends Thread {
        private MyThreadLocal local;

        public ThreadTest(MyThreadLocal local) {
            this.local = local;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "----" + local.getNextNum());
            }
        }
    }
}
