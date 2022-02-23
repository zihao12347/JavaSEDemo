package threaddemo.basic.threadsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全案例：多个线程模拟多个售票窗口进行售票
 *     售票类
 *
 *  线程问题分析：
 *      当多个线程同时对共享的全局变量进行写操作时，一般要考虑线程问题，否则就可能出现线程安全问题
 *
 *  线程解决----线程同步
 *      要解决多线程的安全问题，只要在某个线程在修改共享的变量时，让其他线程不能修改该资源，
 *      等待修改完毕同步后，才能去抢夺cpu资源，完成对应的操作，保证了数据的共享性。
 *
 *   方式一：同步代码
 *   方式二：同步方法
 *   方式三：同步锁 ReentrantLock
 *          在容易出现线程安全问题的代码之前给同步锁对象上锁 lock()
 *          在任务执行完成之后解锁 unlock()
 *
 *
 */
public class Tickets implements Runnable{
    private int tickets=100;
    //创建同步代码块的锁对象，该对象可以为任意类型
    private Object obj=new Object();
    //创建ReentrantLock同步锁，解决线程的安全问题
    private Lock lock=new ReentrantLock(true);//boolean fair 是否使用公平锁，线程是否拥有公平的执行权


    @Override
    public void run() {
        while (true){ //死循环一直执行

            //方式一：同步代码块实现线程的安全  synchronized(lockObject){ 线程任务}
//            synchronized (obj){
//                if (tickets>0) {//当票数大于0才售票
//                    try {
//                        Thread.sleep(100); //休眠0.1秒
//                        String name = Thread.currentThread().getName();
//                        System.out.println("线程:"+name+"售票售一张票，还剩："+ --tickets);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
            //二：调用同步方法
//            sell();
            //三：使用同步锁
            lock.lock();
            try {
                if (tickets>0) {//当票数大于0才售票
                    try {
                        Thread.sleep(100); //休眠0.1秒
                        String name = Thread.currentThread().getName();
                        System.out.println("线程:"+name+"售票售一张票，还剩："+ --tickets);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            finally {
                lock.unlock();//释放锁通常在finally代码块中
            }
        }
    }

    /**
     *
     *  同步售票方法，
     *      方式二：同步方法    在方法上加 synchronized 关键字
     *          把可能出现线程安全的代码抽取到同步方法中
     *
     *      同步方法的锁对象：
     *          1.static静态同步方法：  当前方法所在类的字节码对象（类名.class）
     *          2.非static同步方法： 调用当前方法的对象实例(this)
     *
     *
     */
    private synchronized void sell(){
        if (tickets>0) {//当票数大于0才售票
            try {
                Thread.sleep(100); //休眠0.1秒
                String name = Thread.currentThread().getName();
                System.out.println("线程:"+name+"售票售一张票，还剩："+ --tickets);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
