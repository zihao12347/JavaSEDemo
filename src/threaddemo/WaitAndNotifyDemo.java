package threaddemo;

/**
 * 线程之间的通信案例：也就是线程之间的等待与唤醒机制
 *      等待与唤醒机制：多个线程之间的协作机制：多个线程共同完成某个任务，并且有规律的执行，
 *      那么就需要定义一些通信协议，共同操作某项任务
 *
 *
 *      创建一个顾客线程：告知老板需要的包子种类和数量，调用wait()方法，放弃cpu的执行，进入waiting状态
 *      创建一个老板线程：花5秒做包字，然后调用notify()方法，唤醒顾客取包子
 *    注意：
 *      1.老板和顾客的线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个线程执行，
 *      2.同步使用的锁对象必须保证唯一
 *      3.只有锁对象才能调用wait()和notify()方法
 *    wait() 使当前线程进入等待状态
 *    notify() 唤醒在无限等待的线程
 *    notifyAll() 唤醒所有在无线等待状态的线程
 */
public class WaitAndNotifyDemo {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(){//通过匿名内部类的方式创建线程
            public void run() {
                while (true) {
                    synchronized (lock){//必须使用同步代码块保证锁的唯一
                        System.out.println("顾客一：告知老板需要的包子种类和数量!");
                        try {
                            lock.wait();//通过锁多谢调用wait()方法，进入无限等待状态
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子做好顾客开吃！");
                    }
                }
            }
        }.start();//开启线程
        new Thread(){//通过匿名内部类的方式创建线程
            public void run() {
                while (true) {
                    synchronized (lock){//必须使用同步代码块保证锁的唯一
                        System.out.println("顾客二：告知老板需要的包子种类和数量!");
                        try {
                            lock.wait();//通过锁多谢调用wait()方法，进入无限等待状态
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子做好顾客开吃！");
                    }
                }
            }
        }.start();//开启线程

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);//花5秒做包子
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock){//
                        System.out.println("花5秒做包字，唤醒顾客取包子!");
                        //lock.notify();//notify()唤醒顾客线程
                        lock.notifyAll();//notifyAll()
                    }
                }
            }
        }.start();
    }
}
