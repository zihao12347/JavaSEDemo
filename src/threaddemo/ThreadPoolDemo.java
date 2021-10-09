package threaddemo;

import java.util.concurrent.Executor;
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
 *      创建线程池：
 *          线程池工具的顶级接口java.util.concurrent.executors，是一个执行线程的工具
 *          实现接口ExecutorService,
 *          newFixedThreadPool(int Threads)返回线程池对象 Threads线程池中的线程个数
 *          submit(runnable task)获取线程池中的某一个对象
 *          shutdown()销毁线程，一般不建议
 *      使用步骤：
 *          1.通过Executors的newFixedThreadPool(threads)创建线程并指定线程个数
 *          2.创建一个runnable实现类，指定线程任务
 *          3.调用submit(runnable)方法从线程池中获取线程对象
 *
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建线程池对象，并指定线程个数
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new MyRunable());
        service.submit(new MyRunable());
        service.shutdown();
    }
}
