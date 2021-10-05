package collectiondemo;

/**
 * 含有泛型的接口:
 *      格式：
 *          访问修饰符 class 类名<泛型>{
 *
 *          }
 *      使用：
 *          1.定义接口的实现类时，指定数据类型
 *          2.实现类使用与父接口同样的泛型，在实例化实现类的时候指定数据类型
 *
 */
public class GenericInterface<I> {
    public void method(I i){
        System.out.println(i);
    }

}
