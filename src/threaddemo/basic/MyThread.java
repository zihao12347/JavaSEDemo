package threaddemo.basic;

import java.util.Date;

/**
 * 创建线程方式一：继承Thread类，重新run()方法
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i <10 ; i++) {
            System.out.println("MyThread执行了："+new Date());
        }
    }
}
