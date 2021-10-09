package threaddemo;

/**
 * 进入TimeWaiting（计时等待）状态的两种方式：
 *      sleep(Long s)休眠时间结束后，线程进入runnable或者block状态
 *      wait(Long s)等待时间过后，线程自动唤醒
 */
public class TimeWaitingDemo {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(){//通过匿名内部类的方式创建线程
            public void run() {
                while (true) {
                    synchronized (lock){//必须使用同步代码块保证锁的唯一
                        System.out.println("告知老板需要的包子种类和数量!");
                        try {
                            lock.wait(5000);//指定5秒的等待时间
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子做好顾客开吃！");
                    }
                }
            }
        }.start();//开启线程

    }
}
