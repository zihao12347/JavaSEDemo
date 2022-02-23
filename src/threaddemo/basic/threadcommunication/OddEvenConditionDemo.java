package threaddemo.basic.threadcommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition对象：依赖于Lock锁对象
 *      await()等待方法
 *      signal()唤醒方法
 *      signalAll()唤醒所有线程方法
 */

public class OddEvenConditionDemo {
    public int flag=0;
    public Lock lock=new ReentrantLock(false);
    public Condition condition=lock.newCondition();

    public void odd(){
        lock.lock();
        try {
            while (flag<10) {
                if (flag%2==1) {
                    System.out.println("奇数打印："+flag);
                    flag++;
                    condition.signal();//唤醒偶数打印
                }else {
                    try {
                        condition.await();//等待偶数打印
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void even(){
        lock.lock();
        try {
            while (flag < 10) {
                if (flag % 2 == 0) {
                    System.out.println("偶数打印："+flag);
                    flag++;
                    condition.signal();//唤醒奇数打印
                }else {
                    try {
                        condition.await();//等待偶数打印
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        OddEvenConditionDemo oddEvenCondition = new OddEvenConditionDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenCondition.odd();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenCondition.even();
            }
        }).start();
    }
}
