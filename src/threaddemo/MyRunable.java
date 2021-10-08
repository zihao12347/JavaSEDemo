package threaddemo;

/**
 * 实现多线程方式二：
 *      实现Runnable接口，重写run()方法
 */
public class MyRunable implements Runnable{
    /**
     * 在Runnable实现类在重写run()方法，编写线程任务
     */
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
    }
}
