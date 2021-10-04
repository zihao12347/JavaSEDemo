package staticdemo;

/**
 * 静态代理块：static{
 *              静态代码块内容
 *          },
 *       1.位置：位于类中
 *       2.执行：随着类加载而加载，只执行唯一一次，
 *          优先于main方法和构造方法执行()
 */
public class StaticCodeAreaTest {
    public static void main(String[] args) {
        new StaticCodeArea();
        new StaticCodeArea();//static静态代码块只执行一次
        System.out.println("I AM A MAIN METHOD!");
    }

}
