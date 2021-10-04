package abstractdemo;

/**
 * 抽象类的使用：
 *      不能被直接new实例化抽象类使用
 *      只能通过子类继承复父抽象类进行重写所有的抽象方法
 */
public class Rabbit extends Animal{
    /**
     * 抽象类的子类必须覆盖重写父抽象类的所有抽象方法
     */
    public Rabbit() {
        System.out.println("子类构造方法！");
    }

    @Override
    public void eat() {
        System.out.println("兔子吃草！");
    }
}
