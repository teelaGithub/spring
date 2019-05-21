package com.demo.java;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * java 4种引用类型
 * @author litinglan 2019/5/15 10:17
 */
public class ReferenceDemo {
    public static void main(String[] args) {
        //1、强引用，内存不足会抛错，不会被GC回收
        ReferenceDemo demo = new ReferenceDemo();
//        demo = null;//设null后会被回收
        //2、软引用，内存不足会被GC回收
        SoftReference softReference = new SoftReference(new ReferenceDemo());
        softReference.get();//回收前返回对象的强引用，回收后返回null
        //3、弱引用，无论内存是否不足，垃圾回收时都会被回收
        WeakReference weakReference = new WeakReference(new ReferenceDemo());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
        //4.虚引用，任何时候都会被GC回收
        ReferenceQueue referenceQueue = new ReferenceQueue();//引用队列，当软、弱、虚引用与对象失去联系后将加入此队列
        PhantomReference phantomReference = new PhantomReference(new ReferenceDemo(), referenceQueue);
        phantomReference.get();

    }
}
