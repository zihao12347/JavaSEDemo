package threaddemo;

/**
 * 并发：多个事情，在同一个时间段进行
 * 并行：多个事情，在同一时刻进行（同时发送）
 *
 * 进程：内存中运行的运用程序
 * 线程：进程中的一个执行单位，一个进程中最少有一个线程，一个进程中也可以有多个线程，这个应用程序成为多线程
 *
 * 主线程：执行main方法的线程
 *
 *  创建多线程的两种方式：
 *      1.编写Thread线程类子类，重写run()方法，
 *          使用：实例化Thread线程类子类，调用start()方法开启线程
 *      2编写Runnable实现类，重写run()方法
 *          使用：实例化runnable实现类，通过Thread(Runnable target)类指定runnable对象 ，
 *          再调用start()方法
 *      3.通过匿名内部类的方式实现线程的创建：简化代码
 *
 *  实现Runnable接口比继承Thread类的优势：
 *      1.避免了单继承的局限性
 *          一个类只能继承一个类，继承了Thread类就不能继承其他的类型
 *      2.增强了程序的扩展性，降低耦合
 *          实现runnable接口的方式，把设置线程的任务和开启线程进行了分离
 *
 *  解决线程安全问题：
 *      线程的同步
 *       当多个线程访问统一资源的时候，且有写入的操作，就容易出现线程的安全问题
 *      java中提供了线程的同步机制synchronized解决
 *      三种方式实现同步操作：
 *         1.同步代码块方式
 *             synchronized(同步锁对象){
 *
 *             }
 *            锁对象
 *             作用：
 *                把同步代码块锁住，只让拿到锁的那个线程，在同步代码块中执行任务，其他线程则在外面等待
 *             类型：任意类型
 *       2.同步方法：使用synchronized关键字修饰的方法
 *                将可能出现线程安全的代码抽取放入同步方法中
 *
 *             同步方法中的锁对象：
 *                非static方法，同步锁对象为this(也就是new RunnableImpl()这个对象)
 *                static方法，为静态同步方法所在类的字节码对象
 *       3.锁机制Lock：java.util.concurrent.locks.Lock机制提供的ReentrantLock实现类
 *                 lock:同步加锁
 *                 unlock:释放同步锁
 *             使用：
 *              3.1创建lock实现类对象reentrantLock对象
 *              3.2在可能出现线程安全的代码前调用lock()方法加锁
 *              3.3在执行完可能出现线程安全任务后调用unlock()方法释放锁
 *
 *线程状态（6中）
 *      1.新建状态
 *      2.运行状态
 *      3.阻塞状态
 *      4.休眠砖头
 *      5.等待状态
 *      6.死亡状态
 *
 */
public class DemoMain {
    public static void main(String[] args) throws InterruptedException {
        //获取主线程的名称
        System.out.println("主线程名称："+Thread.currentThread().getName());
        for (int i = 0; i <3 ; i++) {
            Thread.sleep(1000);//sleep()方法指定毫秒暂停
            System.out.println(i);
        }


        //测试线程类，1.实例化子线程对象，2.调用子线程start()方法启动线程
        MyThread myThread1 = new MyThread();
        myThread1.setName("自定义线程名称1");//使用setName()方法，给线程设置名称
        myThread1.start();
        new MyThread("自定义线程名称2").start();//通过构造方法，设置线程名称


        //测试runnable线程
        MyRunable myRunable = new MyRunable();
        new Thread(myRunable).start();
        //通过匿名内部类的方式实现创建线程
        new Thread(new Runnable(){//创建匿名内部类
            @Override
            public void run() {//重写run()方法
                System.out.println(Thread.currentThread().getName());
            }
        }).start();//开启线程

    }
}
