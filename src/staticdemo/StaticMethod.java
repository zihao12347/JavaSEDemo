package staticdemo;


public class StaticMethod {
    int  num;//普通变量
    static int numStatic;//静态变量

    public void method(){
        System.out.println("this is a normal method!");
    }
    public static void staticmethod(){
        System.out.println("this is a static method!");
    }
}
