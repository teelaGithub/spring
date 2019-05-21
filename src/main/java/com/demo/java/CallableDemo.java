package com.demo.java;

import java.util.concurrent.*;

/**
 * Callable多线程：一般结合ExecutorService实现
 * #call方法可返回执行结果
 *
 * @author litinglan 2019/5/15 10:47
 */
public class CallableDemo implements Callable<String> {
    private long waitTime;

    public CallableDemo(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }
}

class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FutureTask可取消任务、获取任务执行结果
        //Future是接口无法实例化，因此就有了FutureTask
        FutureTask futureTask1 = new FutureTask(new CallableDemo(1000));
        FutureTask futureTask2 = new FutureTask(new CallableDemo(2000));

        ExecutorService executorService = Executors.newFixedThreadPool(2);//创建容量为2的线程池
        executorService.execute(futureTask1);//执行任务
        executorService.execute(futureTask2);

//        futureTask1.cancel(false);//取消任务
//        futureTask1.isDone();//任务是否完成
//        futureTask1.get();//获取任务执行结果，会产生阻塞，一直到任务执行完毕返回结果
    }
}
