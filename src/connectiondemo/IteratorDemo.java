package connectiondemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * iterator迭代器：用于遍历Collection集合中所有的元素，
 *          因为Connection集合没有索引，通过iterator迭代器进行遍历
 *          创建迭代器：
 *                通过Collection集合的iterator()方法获取迭代器接口的实现类
 *           方法：
 *              hasNext() 判断集合中是否还有下一个元素
 *              next() 获取集合中下一个元素
 *
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> collection=new ArrayList<>();
        collection.add("hello");
        collection.add("world");
        collection.add("heima");
        collection.add("java");
        collection.add("!");
        //通过iterator()方法，创建iterator对象
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {//hasNext()方法判断是否有下一元素
            String s = iterator.next();//next()方法，获取元素对象
            System.out.println(s);
        }
    }
}
