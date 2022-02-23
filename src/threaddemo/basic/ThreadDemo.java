package threaddemo.basic;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    /**
     * 1.创建自定义线程实例
     * 2.启动自定义线程：
     * 3.启动main主线程打印信息；main方法在执行时，会创建一个线程，该线程为主线程；
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //一：继承Thread类创建线程对象，调用start()方法启动线程
//        MyThread myThread=new MyThread();
//        myThread.start();

        //，通过指定Thread(runnable target)线程的目标runnable，
        /**
         * 二：实现Runnable接口创建线程，
         * 开启线程：
         *   指定Thread(runnable target)线程类目标runnable对象，创建线程对象，
         *   调用start()方法启动线程
         */
//        MyRunnable myRunnable=new MyRunnable();//创建runnable对象
//        new Thread(myRunnable,"myRunnable").start();//指定线程对象的目标runnable，启动线程
        //通过匿名内部类创建runnable对象方式实现创建线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("匿名内部类方式创建线程对象"+new Date().getTime());
//            }
//        }).start();
        /**
         * 三：通过实现Callable接口创建线程；
         *      Callable需要使用FutureTask类的帮助执行
         *      FutureTask类：继承了RunnableFuture接口，RunnableFuture接口继承了Runnale，Future接口，
         *                   FutureTask类因此可以当作Runnable实现类使用
         */

        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
        new Thread(futureTask).start();
        for (int i = 0; i <2 ; i++) {
            System.out.println("main主线程执行了："+new Date());
        }
        System.out.println(futureTask.get());//get()获取完成执行结果
        System.out.println(futureTask.isDone());//isDone()是否执行完成
    }
}
