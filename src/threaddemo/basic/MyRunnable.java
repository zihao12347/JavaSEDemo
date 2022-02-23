package threaddemo.basic;

import java.util.Date;

/**
 * 创建线程方式二：实现runnable接口，重新run()方法
 */
public class MyRunnable implements Runnable{
    /**
     * 重写run()方法，获取并打印当前线程名称，
     *      Thread.currentThread().getName()：获取当前线程
     */
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("MyRunnable执行了！"+Thread.currentThread().getName()+"--"+new Date().getTime());
        }
    }
}
