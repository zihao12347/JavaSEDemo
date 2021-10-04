package interfacedemo;

/**
 * 接口：是java中的一种引用类型，是方法的集合
 *      引用类型：数组，接口，类，String
 *     一：接口中可以包含的内容：
 *          1.常类：public static final(关键字可省略) 数据类型 常量名称，该常量在声明时必须进行赋值； 一旦被赋值，不可改变
 *               使用：直接通过接口调用
 *
 *          2.抽象方法： 默认为：public abstract 可以省略
 *              使用：通过实现类实现接口中所有的抽象方法
 *          3.默认方法： default修饰，解决接口升级问题
 *              public default 返回值类型 方法名称（）{
 *                  方法体
 *              }
 *              使用：可以在实现类中实现该默认方法，需要时，通过实现类直接调用，或者被实现类覆盖重写
 *          4.静态方法： static修饰
 *                 public static 返回类型 方法名称(){
 *                     方法体
 *                 }
 *                使用：静态内容是属于类的，所以直接通过接口调用静态方法
 *          5.私有方法：JDK9版本提供私有方法 private修饰
 *              5.1普通私有方法：解决多个默认方法中的代码重复问题
 *                  private 返回值类型 方法名称(){
 *                      方法体
 *                  }
 *              5.2静态私有方法：解决多个静态方法中的代码重复问题
 *                  private static 返回值类型 方法名称(){
 *                      方法体
 *                  }
 *        二：接口的使用：
 *              一个类可以同时实现多个接口
 *
 */
public interface MyInterfaceAbstract {

    public static final int num=10;//常量

    public abstract void abstractMethodOne();//抽象方法
    public void abstractMethodTwo();//抽象方法，abstract可省略
    void abstractMethodThree();//抽象方法，public abstract都可省略

    /**JDK8版本允许在接口中定义默认方法，
     *      默认方法有返回值
     *
     */
    public default void defaultMethod(){
        System.out.println("这是新添加的默认方法！");

    }

    /**JDK8版本允许了在接口中定义静态方法
     *
     */
    public static void staticMethod(){
        System.out.println("这是新添加的静态方法！");
    }

    /*private void privateMethod(){
        System.out.println("我是接口中的私有方法！");
    }*/
}
