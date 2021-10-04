package interfacedemo;

public class MyInterfaceAbstractImpl implements MyInterfaceAbstract {
    @Override
    public void abstractMethodOne() {

    }

    @Override
    public void abstractMethodTwo() {

    }

    @Override
    public void abstractMethodThree() {

    }

    //覆盖重写接口中的默认方法
    @Override
    public void defaultMethod() {
        System.out.println("这是实现类中覆盖重写了接口中的默认方法！");
    }
}
