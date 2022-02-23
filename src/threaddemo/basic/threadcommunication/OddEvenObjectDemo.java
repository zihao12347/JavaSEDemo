package threaddemo.basic.threadcommunication;


/**
 * Object对象：依赖于synchronized的同步代码块/方法，否则报错
 *      wait()等待方法
 *      notify()唤醒方法
 *      notifyAll()唤醒所有等待线程方法
 */
public class OddEvenObjectDemo {
    public int flag=0;
    public Object object=new Object();
    /**
     * 打印奇数方法
     */
    public void odd()  {
        synchronized (object){
            while (flag<10) {
                if (flag % 2 == 1) {
                    System.out.println("打印奇数："+flag);
                    flag++;
                    object.notify();//奇数打印完成，唤醒偶数

                }else {//偶数打印，技术方法等待
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    /**
     * 打印偶数方法
     */
    public void even(){
        synchronized (object){
            while (flag<10) {
                if (flag%2==0) {
                    System.out.println("打印偶数："+flag);
                    flag++;
                    object.notify();//偶数打印完成，唤醒奇数打印
                }else {
                    try {
                        object.wait();//等待奇数打印
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        final OddEvenObjectDemo oddEvenDemo = new OddEvenObjectDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenDemo.even();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenDemo.odd();
            }
        }).start();
    }

}
