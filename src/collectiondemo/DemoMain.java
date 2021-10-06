package collectiondemo;

import java.util.ArrayList;
import java.util.Collection;
/**
 * Collection：单例集合的根接口，没有索引，重写了toString()方法
 *      1.list集合：
 *          特点：
 *              有序集合(存储和取出的元素顺序相同)，可重复存储元素，有索引可以for进行遍历、
 *          类别：
 *              arraylist（重点）,底层是数组实现，查询快，增删慢。
 *              linkedlist：底层链表实现，增删快，查询慢
 *              vector
 *      2.set集合：
 *          特点：
 *              无序集合，不可重复元素，没有索引
 *           类别：
 *              hashset（重点）:底层是哈希+红黑树实现，无引索，元素不可重复，存取无序
 *              treeset:底层是二叉树实现，一般用于排序
 *              linkedset(有序集合)：底层是哈希+链表实现，无引索，不可重复，有序
 *      3.使用方法：
 *          add() 添加元素
 *          get(index) 获取元素
 *          remove() 删除某个元素
 *          clear() 清空集合在所有的元素
 *          isEmpty() 判断集合是否为空
 *          toArray() 将集合转换成数组
 *          size() 集合中的元素
 *          iterator() 返回Iterator迭代器的实现类对象、
 *      4.增强for循环：底层也是使用迭代器 ，使用for循环的格式，简化代码的书写，JDK1.5版本之后的
 *          for(元素数据类型 变量：Collection集合 or Array数组){
 *
 *          }
 *
 *
 *
 */
public class DemoMain {
    public static void main(String[] args) {
        Collection<String> conn=new ArrayList<>();//创建Collection集合
        conn.add("hello");//添加元素
        conn.add("world");
        conn.add("heima");
        conn.add("java");

        int size = conn.size();//获取集合中的元素个数
        System.out.println(size);

        Object[] objects = conn.toArray();//将集合转换成一个数组
        for (Object object : objects) {
            System.out.println(object.toString());
        }

        System.out.println(conn);//connection集合重写了toString()方法

        conn.remove("java");//remove()删除某个元素

        boolean contains = conn.contains("hello");//判断集合中是否包含某个元素
        System.out.println(contains);

        boolean empty = conn.isEmpty();//判断集合是否为空
        System.out.println(empty);

        conn.clear();//清空所有元素
        System.out.println(conn);

        for (String s : conn) {//使用增强for进行循环遍历
            System.out.println(s);
        }
    }
}
