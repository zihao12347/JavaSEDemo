package abstractdemo;

/**抽象类：被abstract关键字修饰的类，必须包含抽象方法的类
 * 抽象方法：被abstract关键字修饰的方法，并且没有方法主体
 */
public abstract class Animal {//抽象类

    public Animal() {//抽象类中可以有构造方法
        System.out.println("抽象父类的构造方法！");
    }

    public abstract void eat();//抽象方法

    /**
     * 抽象类：并不一定包含抽象方法，但是有抽象方法的类一定是抽象类
     */
    public abstract class AnimalTwo{//内部类

    }
}


