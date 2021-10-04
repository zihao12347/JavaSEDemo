package interfacedemo;

public class MyInterfaceAbstractTest {
    public static void main(String[] args) {
        MyInterfaceAbstractImpl myInterfaceAbstract = new MyInterfaceAbstractImpl();
        System.out.println( MyInterfaceAbstract.num);//调用接口中的常量
        myInterfaceAbstract.defaultMethod();//调用接口中的默认方法
        MyInterfaceAbstract.staticMethod();//通过接口调用接口中的静态方法

    }
}
