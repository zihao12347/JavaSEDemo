package threaddemo.basic.threadsafe;

/**
 * 线程安全问题：当多个线程模拟多个售票窗口时，出现了多线程的安全问题
 *      问题：
 *          1.相同的票被多个线程同时出售
 *          2.出现不存在的票，0和负数的票
 *
 */
public class TicketsDemo {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        //模拟5个窗口售票
        new Thread(tickets,"窗口一").start();
        new Thread(tickets,"窗口二").start();
        new Thread(tickets,"窗口三").start();
        new Thread(tickets,"窗口四").start();
        new Thread(tickets,"窗口五").start();
    }
}
