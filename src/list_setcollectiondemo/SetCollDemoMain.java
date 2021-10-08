package list_setcollectiondemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Set集合：无索引，不能重复，无序（不能进行普通for循环）
 *    类别：
 *       hashSet:底层是哈希表结构（查询速度非常快）
 *          特点：无序，没有索引，元素不能重复
 *
 *      存储数据结构（哈希表）:
 *        jdk1.8版本之前，哈希表：数组+单项链表
 *        jdk1.8版本之后，哈希表：数组+单项链表+红黑树（提供查询效率）
 *            数组分类：把元素的哈希值相同的分成一组
 *            链表/哈希表结构：把哈希值相同的元素连接在一起，当链表长度大于8时，自动转换成红黑树
 *      元素不能重复的原因：
 *          Set集合在调用add()方法时，add方法会调用元素的hashcode方法先进行元素分组，，和equals方法再进行判断元素是否重复
 *      在存储自定义类型的元素时，必须重写hashCode()和equals()方法，才能保证元素存储的不重复
 *
 *      linkedSet(有序集合):底层是链表+哈希组合
 */
public class SetCollDemoMain {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2);//不能重复
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {//通过iterator迭代器进行遍历
            System.out.println(iterator.next());
        }
        for (Integer integer : hashSet) {//通过增强for进行遍历
            System.out.println(integer);
        }
        testOne();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList);

    }

    /**
     * 要求：同年龄和姓名的人，只能存储一次；
     *      可以看出p1和p2本来是重复了，只能存储一次，但是结果都存储了，
     *      解决方案：add()方法在存储时，只能存储一次是因为它调用了元素的hashCode()方法和equals方法，进行判断
     *              所以在persion类在重写hashCode()和equals()方法
     */
    public static void testOne(){
        HashSet<Person> persions = new HashSet<>();
        Person p1 = new Person("张三", 18);
        Person p2 = new Person("张三", 18);
        Person p3 = new Person("李四", 21);

        System.out.println( p1.hashCode());

        System.out.println( p2.hashCode());
        persions.add(p1);
        persions.add(p2);
        persions.add(p3);
        System.out.println(persions);
    }
}
