package collectiondemo;

/**
 * 使用含有泛型的接口：
 *      方式二：实现类使用与夫接口同样的泛型，在实例化实现类的时候指定数据类型
 * @param <I>
 */
public class GenericInterfaceImplTwo<I> extends GenericInterface<I> {
    @Override
    public void method(I i) {
        super.method(i);
    }
}
