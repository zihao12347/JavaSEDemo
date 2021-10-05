package collectiondemo;

/**
 * 使用含有泛型的接口
 *      1.在接口的实现类中指定含有父接口的数据类型
 */
public class GenericInfaceImpl extends GenericInterface<String> {
    @Override
    public void method(String s) {
        super.method(s);
    }
}
