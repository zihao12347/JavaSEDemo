package collectiondemo;

/**
 *  含有泛型的类:
 *      格式：
 *          访问修饰符 class 类名<泛型>{
 *
 *          }
 *       使用：在实例化对象的时候指定数据类型
 *
 * @param <E>
 */
public class GenericClass<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "name=" + name +
                '}';
    }
}
