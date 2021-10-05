package collectiondemo;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Iterator;

/** 泛型
 *     1.通配符<?>：当使用泛型类或者泛型接口的时候，传递数据中，泛型类型不确定，可以使用通配符?表示;
 *      ?:代表任意类型的数据
 *     2.泛型的高级使用：泛型的上限和下限
 *         泛型的上限限定：
 *              <? extends 类>：代表使用的泛型只能是当前类型，和它的子类
 *         泛型的下限限定
 *              <? super 类>：代表使用的类型只能是当前类型，或它的父类
 */
public class GenericWildcard {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(10);
        test(list);
        test(list2);
        //测试泛型的上限类型：？extends Class 泛型限定于子类或者当前类类型
        ArrayList<Integer> coll1 = new ArrayList<>();//Number类型包含 int,double,byte,float，long，short等
        ArrayList<Number> coll2 = new ArrayList<>();
        ArrayList<String> coll3 = new ArrayList<>();
        ArrayList<Object> coll4 = new ArrayList<>();
        getColl1(coll1);
        getColl1(coll2);
        //getColl1(coll3);报错，String类型不属于Number类中
        //getColl1(coll4);报错，Object类，是所有类的父类，但是泛型的上限限定只能是当前类或子类类型

        //测试泛型的下限限定：? super Class 表示泛型只能是当前类或父类类型
        //getColl2(coll1);//报错，Integer为Number类的子类，不满足泛型的下限限定
        getColl2(coll2);
       //getColl2(coll3);//报错，String类型不是Number类型
        getColl2(coll4);//满足。Object类是所有类的父类
    }

    /**
     * 在传递方法参数时，使用泛型的通配符，表示不确定传递参数的类型
     * @param list
     */
    public static void test(ArrayList<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * 泛型的上限限定：？ extends Class 泛型类型只能是当前类的子类及其当前类类型
     * @param list
     */
    public static void getColl1(ArrayList<? extends Number> list){
        Iterator<? extends Number> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 泛型的下限限定：？ super Class 泛型类型限定为当前类父类或当前类型
     * @param list
     */
    public static void getColl2(ArrayList<? super Number> list){
        Iterator<? super Number> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
