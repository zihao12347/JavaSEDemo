package threaddemo.basic;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用：
 *      线程池：就是一个容纳多个线程的容器，其中的线程可以反复的使用，省去了频繁创建线程的操作，
 *             无需反复创建线程而导致内存消耗过多,
 *             线程池会一直开启，使用完成线程后，会自动归还线程到线程池中
 *      使用线程池的好处：
 *          1.降低资源消耗
 *          2.提供响应速度
 *          3.提高线程的可管理性
 *       线程池的创建：
 *            线程池的顶级接口Excutor，快速创建线程池的工具类：Excutors
 *            创建步骤：
 *              1.实现Runnable接口，指定线程任务
 *              2.通过Excutors工具类的fixedThreadPool(int threads)方法指定线程数据
 *              3.调用submit(runnable)方法从线程池获取线程，执行任务
 *              shutdown()销毁线程，一般不建议
 */
public class TheadPoolDemo {
    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
            System.out.println("主线程执行："+Thread.currentThread().getName()+""+new Date());
        }
        /**
         * 线程池执行线程任务：
         *      1.通过Excutors工具类的fixedThreadPool()指定线程熟练，创建线程池
         *      2.调用submit(runnable)方法执行线程
         */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new MyRunnable());
    }
}
