package staticdemo;

/**
 * 静态方法：被static修饰的成员方法。也是属性类，优于对象，
 * 当用方式：类名称.静态方法名称()，进行调用
 * <p>注意事项
 * 一：静态方法不能访问非静态的变量和方法。
 *  原因：static修饰的内容，
 *      1.随着类加载而加载，只加载一次，所以能被类直接调用
 *      2.它存储在固定的静态内存区，
 *      3.它优于对象存在，所以可以被所以对象共享
 *   二：静态方法中不能使用this关键字：this指代当前对象
 *
 */
public class StaticMethodTest {
    int a;

    public static void main(String[] args) {
        //a=3; 静态方法不能访问非静态的变量
        //调用静态方法
        StaticMethod.staticmethod();
        //调用普通方法
        StaticMethod staticMethod = new StaticMethod();//1.先创建对象
        staticMethod.method();//再根据对象进行调用普通方法
        //test(); 静态方法不能调用非静态的方法
    }

    public void test(){
        System.out.println("I AIN'T A STATIC METHOD! ");
    }
}
