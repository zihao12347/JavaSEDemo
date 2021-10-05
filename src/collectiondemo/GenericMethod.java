package collectiondemo;

/**
 * 定义一个含有泛型的方法：
 *         格式：
 *              访问修饰符  <泛型> 返回值 方法名(参数){
 *
 *              }
 *          使用：
 *              在调用含有泛型的方法时，指定数据类型
 */
public class GenericMethod {
    //定义一个含有泛型的方法
    public <M> void methodOne(M m){
        System.out.println(m);
    }

    public static <S> void methodTwo(S s){
        System.out.println(s);
    }

}
