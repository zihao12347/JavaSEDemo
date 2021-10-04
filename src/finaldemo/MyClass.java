package finaldemo;

/**
 * final关键字：可以用来修饰类，变量，方法,不能与abstract关键字同时使用
*   修饰类：不可被继承
*   修饰方法：不可被重写
*   修饰变量：不可被重新赋值
 *    修饰成员变量：
 *         必须手动赋值，因为成员变量会有一个默认值；
 *     修饰局部变量：
 *          修饰基本数量类型，不能改变变量的值
 *           修饰引用类型，不能改变变量的存储空间地址，但是不影响对象内部成员变量值的修改
 *
 */
public class MyClass {
    private final int num=2;//final修饰的成员变量必须手动赋值
    private final int num2;
    public MyClass() {
        num2=4;//通过构造方法手动赋值
    }

    public static void main(String[] args) {
        int num1=10;
        num1=20;
        System.out.println(num1);
        final int num2=20;
        //num2=30;被final关键字修饰的局部变量不可被更改

    }
}
