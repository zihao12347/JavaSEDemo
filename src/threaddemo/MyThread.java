package threaddemo;

/**
 * 创建线程类：
 *      继承thread接口，并重写run方法，
 *   Thread类的构造方法：
 *      Thread() 分配一个新的线程对象
 *      Thread(String name) 指定名称的线程对象
 *      Thread(Runnable target) 指定目标对象的线程对象
 *
 *
 *   Thread类方法：
 *        getName() 获取当前线程名称
 *        currentThread() 返回当前正在执行线程对象的引用
 *        setName() 设置线程名称 也可以通过重写Thread(String name)构造方法，在实例化线程对象时，设置线程名称
 *        start() 开启执行线程
 *        run() 线程需要执行的任务
 *        sleep() 指定毫秒数的暂停
 *
 *
 *
 */
public class MyThread extends Thread{
    public MyThread(){

    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        String threadName =getName();//getName()方法，获取线程名称
        System.out.println(threadName);
        Thread currentThread = currentThread();
        System.out.println(currentThread);
        System.out.println(currentThread().getName());
    }
}
