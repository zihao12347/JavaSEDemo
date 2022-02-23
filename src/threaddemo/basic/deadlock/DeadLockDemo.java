package threaddemo.basic.deadlock;

public class DeadLockDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable(1);
        MyRunnable myRunnable2 = new MyRunnable(2);
        new Thread(myRunnable).start();
        new Thread(myRunnable2).start();
    }
}
