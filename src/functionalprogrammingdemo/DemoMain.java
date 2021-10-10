package functionalprogrammingdemo;

/**
 * 函数式接口：该接口有且仅有一个抽象方法
 *      使用：一般可以作为方法的参数，或者返回值类型
 *   常用的函数式方法：
 *      1.supplier<T>接口：仅包含一个无参的抽象方法：也称之为生产类型的接口
 *          指定接口T泛型是什么类型，get()方法就获取什么类型数据
 *        方法
 *          get() 用来获取T泛型类型参数指定类型的对象数据
 */
public class DemoMain {
    public static void main(String[] args) {
        invokemethod(new FunctionalInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类方式调用!");
            }
        });
        invokemethod(()->{
            System.out.println("使用函数式接口！");
        });
    }
    public static void invokemethod(FunctionalInterface functionalInterface){
        functionalInterface.method();
    }
}
