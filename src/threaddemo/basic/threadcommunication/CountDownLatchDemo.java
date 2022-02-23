package threaddemo.basic.threadcommunication;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch的休眠唤醒方式：
 *      CountDownLatch是在java1.5版本之后引入的，在java.util.concurrent包下。
 *      CountDownLatch：用于某线程等待诺干个其他线程执行完成之后，才执行
 *      构造方法的参数用于指定等待其他线程的数量。
 */
public class CountDownLatchDemo {
    //创建CountDownLatch计数对象,并执行计数线程数量
    public CountDownLatch countDownLatch=new CountDownLatch(3);
    public Object obj=new Object();
    /**
     * 球员方法
     */
    public void  racer(){
        synchronized (obj){
            System.out.println(Thread.currentThread().getName()+"球员正在准备中！");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();//计数，-1线程
        }
    }

    /**
     * 教练方法，教练必须等待球员全部准备好才开始宣布比赛
     */
    public void coach(){
        System.out.println("教练准备完成，等待球员");
        try {
            countDownLatch.await();//等待其他线程执行完成再执行。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("球员准备完毕，开始比赛！");
    }

    public static void main(String[] args) {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatchDemo.coach();//教练开始等待球员准备，
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatchDemo.racer();//球员1准备中
            }
        },"球员一").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatchDemo.racer();//球员1准备中
            }
        },"球员二").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatchDemo.racer();//球员1准备中
            }
        },"球员三").start();
    }


}
