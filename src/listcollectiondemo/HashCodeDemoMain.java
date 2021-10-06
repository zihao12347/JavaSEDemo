package listcollectiondemo;

import java.util.Objects;

/**
 *  哈希值：十进制的整数，由系统随机的给出的值（就是对象的地址，该地址是一个逻辑地址，不是实际地址值）
 *      Object类，提供一个hashCode()方法，可以获取对象的哈希值
 *          public native int hashCode(); native代表该方法调用的是本地操作系统的方法
 */
public class HashCodeDemoMain {
    public static void main(String[] args) {
        Persion persion1 = new Persion();//persion普通类，默认继承Object类
        int hashCode1 = persion1.hashCode();//hashCode()方法，返回哈希值
        System.out.println(hashCode1);
        Persion persion2 = new Persion();
        int hashCode2 = persion2.hashCode();
        System.out.println(hashCode2);
        System.out.println(persion1==persion2);

        System.out.println("==================  ");
        /**
         * String类的哈希值：String类重写了Object类的hashCode方法
         *
         */

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

    }
}
