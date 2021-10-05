package collectiondemo;

/**
 * 泛型：在类或方法中预制地使用未知的类型
 *      使用；泛型可以应用到不同的类，接口，方法中，将数据类型作为参数进行传递
 */
public class GenericDemoMain {
    public static void main(String[] args) {
        //在创建含有泛型类的时候，指定数据类型，不指定泛型的类型，默认为Object类型
        GenericClass<Object> demoOne = new GenericClass<>();
        demoOne.setName("只能是字符串");
        System.out.println(demoOne);
        //创建GenericDemoOne对象，泛型指定为String类型
        GenericClass<Integer> demoTwo = new GenericClass<>();
        demoTwo.setName(3);
        System.out.println(demoTwo);

        GenericMethod genericMethod = new GenericMethod();
        //在调用含有泛型的方法时候，指定数据类型
        genericMethod.methodOne("张三");

        //之间通过类名调用含有泛型的静态方法，并且指定数据类型
        GenericMethod.methodTwo(3);

        //测试含有泛型的接口
        GenericInfaceImpl genericInface = new GenericInfaceImpl();
        genericInface.method("李四");

        //测试实现类和父接口都指定相同的泛型，在实例化时候指定数据类型
        GenericInterfaceImplTwo<Boolean> interfaceTwo = new GenericInterfaceImplTwo<>();
        interfaceTwo.method(true);

    }
}
