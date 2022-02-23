package threaddemo.basic.threadcommunication;

/**
 * 线程通信：
 *      多个线程并发执行时，默认情况是CPU随机切换线程，当希望CPU按照规律执行线程，
 *      那么多个线程之间就要协调通信。
 *    线程之间的通信方式：
 *      唤醒和休眠方式：
 *        一：Object:   wait(), notify(), notifyAll()
 *                *object类的休眠和唤醒必须放在synchronized同步代码块/方法中使用，
 *                 否则回报IllegalMonitorStatusException错
 *        二：Condition:  await(), signal(), signalAll()
 *                 Condition类的休眠依赖于Lock锁对象的
 *
 */
public class App {

}
