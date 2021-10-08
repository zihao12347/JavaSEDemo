package threaddemo.treadsafe;

/**
 * 测试卖票案例：
 *      创建3个线程，同时开启，对共享的票进行出售
 *   卖票出现了多个线程同时卖同一张票，或者出现了卖负数的票，等线程安全问题
 *   可知，这几个线程卖的票数不同步，这种问题成为线程不安全
 *   如果多个线程对全局遍历执行写的操作，一般需要考虑线程的同步问题，否则可能影响线程的安全
 *
 *   线程的同步
 *      当多个线程访问统一资源的时候，且有写入的操作，就容易出现线程的安全问题
 *      java中提供了线程的同步机制synchronized解决
 *      三种方式实现同步操作：
 *          1.同步代码块问题
 *              synchronized(同步锁对象){
 *
 *              }
 *             锁对象
 *              作用：
 *                 把同步代码块锁住，只让拿到锁的那个线程，在同步代码块中执行任务，其他线程则在外面等待
 *              类型：任意类型
 *
 *          2.同步方法：使用synchronized关键字修饰的方法
 *                将可能出现线程安全的代码抽取放入同步方法中
 *
 *             同步方法中的锁对象：
 *                非static方法，同步锁对象为this(也就是new RunnableImpl()这个对象)
 *                static方法，为静态同步方法所在类的字节码对象
 *
 *          3.锁机制Lock：java.util.concurrent.locks.Lock机制提供的ReentrantLock实现类
 *                  lock:同步加锁
 *                  unlock:释放同步锁
 *              使用：
 *                 3.1创建lock实现类对象reentrantLock对象
 *                 3.2在可能出现线程安全的代码前调用lock()方法加锁
 *                 3.3在执行完可能出现线程安全任务后调用unlock()方法释放锁
 *
 *
 *
 */
public class Ticket {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
