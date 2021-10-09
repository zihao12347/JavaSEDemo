package functionalprogrammingdemo;

/**
 * 函数式接口：该接口有且仅有一个抽象方法
 *      使用：一般可以作为方法的参数，或者返回值类型
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
