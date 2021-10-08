package threaddemo.treadsafe;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过实现runnable接口的方式创建线程
 */
public class RunnableImpl implements Runnable {
    private static int tickets=100;
    Object lock=new Object();//创建同步锁对象，锁对象可以为任意类型
    Lock reentrantLock=new ReentrantLock();//创建reentrantlock对象，提供了lock加锁和unlock释放锁的方法
    @Override
    public void run() {//设置线程任务：卖票
        while (true){//使用死循环，重复执行
            //使用同步代码块解决线程同步的安全问题
            /**
             * 解决线程安全方式一：使用同步代码块实现
             * synchronized (lock){
             *                 if (tickets>0) {
             *                     try {
             *                         Thread.sleep(2);
             *                     } catch (InterruptedException e) {
             *                         e.printStackTrace();
             *                     }
             *                     System.out.println(Thread.currentThread().getName()+"正在卖第"+tickets--+"张票");
             *                 }
             *             }
             */

            /**
             * 解决线程安全方式二：2.1调用非静态同步方法
             *  payTickets();
             */
            /**
             * 2.2调用静态同步方法
             * staticpayTickets();
             */


            /**
             * 解决线程安全方式三：使用锁机制：
             *      3.1创建ReentrantLock成员变量
             *      3.2使用lock()方法加锁和unlock()方法解锁
             */
            reentrantLock.lock();//同步加锁
            if (tickets>0) {
                try {
                    Thread.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+tickets--+"张票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();//同步释放锁
                }
            }

        }
    }

    /**
     * 通过非静态同步方法解决线程安全的问题：
     *      1.将可能出现线程安全问题的代码抽取出来，放入同步方法中
     *    锁对象：
     *      为this(也就是new RunnableImpl()对象)
     */
    public synchronized void payTickets(){
        if (tickets>0) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在卖第"+tickets--+"张票");
        }
    }
    /**
     *静态同步方法
     *      锁对象：为本类的字节码对象
     */
    public static synchronized void staticpayTickets(){
        if (tickets>0) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在卖第"+tickets--+"张票");
        }
    }
}
