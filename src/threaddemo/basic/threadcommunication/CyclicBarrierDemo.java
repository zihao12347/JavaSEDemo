package threaddemo.basic.threadcommunication;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier类：在java1.5版本引入，存在java.util.concurrent包下
 *      CyclicBarrier实现让一组线程等待至某种状态后，再全部同时执行
 *      底层基于ReentrantLock和condition实现
 *      new CyclicBarrier()构造方法参数
 */
public class CyclicBarrierDemo {
    //创建CyclicBarrier对象，指定参数的线程数量
    private CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
    public void startThread(){
        String name = Thread.currentThread().getName();
        //打印线程准备启动
        System.out.println(name+"正在准备中！");
        //调用CyclicBarrier的await()方法全部等待
        try {
            cyclicBarrier.await();//等待所有参与的线程调用此方法，再执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        //等待所有线程准备好之后，全部执行
        System.out.println(name+"执行完毕！"+System.currentTimeMillis());
    }

    public static void main(String[] args) {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cyclicBarrierDemo.startThread();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cyclicBarrierDemo.startThread();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cyclicBarrierDemo.startThread();
            }
        }).start();

    }
}
