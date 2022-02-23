package threaddemo.basic.deadlock;

/**
 * 死锁案例：一个线程获取锁资源，由于synchronized特性，其他线程获取不到该锁资源，造成一直死等
 *          的局面
 */
public class MyRunnable implements  Runnable{
    private int flat;
    public static Object obj1=new Object(); //锁对象1
    public static  Object obj2=new Object(); //锁对象2

    public MyRunnable(int flat) {
        this.flat = flat;
    }

    @Override
    public void run() {
        if (flat==1) {
            System.out.println(Thread.currentThread().getName()+"已获取到线程1，请求线程二！");
            synchronized (obj1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
              synchronized (obj2){
                  System.out.println(Thread.currentThread().getName()+"已获取到线程一和线程二！");
              }
            }
        }else {
            synchronized (obj2){
                System.out.println(Thread.currentThread().getName()+"以获取线程二，请求线程一！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName()+"以获取到线程一和二！");
                }
            }

        }

    }
}
