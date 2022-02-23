package threaddemo.basic;

/**
 * 线程高级：基础部分
 *
 *    并发：多个事件在同一个时间段发生
 *    并行：多个事件在同一时刻发生
 *
 *     进程：内存中正在运行的程序实例
 *     线程：进程内部的独立执行单位
 *     多线程：多个线程并发执行
 *
 *     创建线程的四种方式：
 *          1.继承Thread类，重写run()方法
 *          2.实现Runnable接口，从写run()方法
 *              使用：创建Thread(runnable target)对象时,指定目标runnable对象
 *
 *          3.实现Callale接口，并指定泛型（该泛型为call()方法的返回值），重写call()方法，能返回执行结果；
 *              使用：通过FutureTask类，执行线程：
 *                      *FutureTask类：实现了RunnableFuture接口，RunnableFuture接口实现了，Runnable接口和Future接口；
 *                                     所以FutureTask类，相当于Runnable的实现类的作用。
 *                       Future类：
 *                              get()方法：获取执行任务结果
 *                              cancel()方法：中断执行
 *                              isDone()方法：任务是否完成
 *          4.线程池：顶级接口Excutor，快速创建线程池的工具类：Excutors
 *                  fixedThreadPool(size)方法指定线程数量
 *                  submit(runnable)方法：从线程池中获取线程，执行任务
 *                  shutdown()方法：销毁线程，不推荐使用
 *
 *
 *
 *
 */
public class App {
}
