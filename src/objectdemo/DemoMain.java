package objectdemo;

import java.util.Objects;

/**
 * Object对象：所以类的父类,当一个类没有指定父类，那么该类默认继承Object类
 *   Object包含的方法：toString(),equals()方法
 *   1.toString()方法:返回该对象的字符串表示：对象类型+@+存储地址值
 *       在实际开发中:通常重写toString()方法，将对象的属性以字符串形式表现
 *
 *
 *   2.equals()方法：
 *      public boolean equals(Object obj) {
 *         return (this == obj);
 *      }
 *      ==：比较运算符，
 *      1.基本类型比较值，
 *      2.引用类型比较地址
 *      所以Object()中的equals方法底层是使用==比较符号进行比较：只能比较引用类型
 *      1.默认比较的是两个对象的地址
 *      2.当重写了equals()方法，就比较对象中的属性值
 *      重写Object对象的equals()方法，让两个对象的属性值进行比较
 *
 *      JDK7版本提供Objects工具类；它提供的equals()方法，能够防止空指针异常问题
 */
public class DemoMain /*extends Object**/{
    public static void main(String[] args) {
        Persion persion1 = new Persion("张三",20);
        //persion类重写了toString()方法，打印对象的属性
        //System.out.println(persion1.toString());
        Persion persion2 = new Persion("张三",20);
        //重写equals()方法，让两个对象的属性值进行比较
        System.out.println(persion1.equals(persion2));

        Persion persion3=null;
        Objects.equals(persion1, persion2);
        Objects.equals(persion2, persion3);
    }
}
