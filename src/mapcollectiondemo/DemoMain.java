package mapcollectiondemo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *  java.util.map<k,v>集合
 *  Map集合
 *    特点：
 *      2.map集合中，key元素不能重复，value可以重复
 *      1.map集合是一个双例集合，包括两个部分（key键,value值）
 *      3.map集合中，key/value值的数据类型，可以相同也可以不相同
 *    类别：
 *      hastMap<k,v>,底层是哈希表结构，查询速度特点快，无序集合
 *          哈希表结构：
 *              jdk1.8版本之前：数组+单向链表
 *              jdk1.8版本之后  数组+单向链表+红黑树（提高查询效率）
 *      linkedMap<k,v>底层是哈希+链表结构(保证迭代的顺序),继承hashMap
 *          特点：有序集合
 *      hashTable:底层也是哈希表结构，
 *          特点：不允许存储null值/键
 *    hashMap与hashTable集合区别：
 *      hashTable：单线程集合，一个线程安全的集合，速度较慢，不运训存储null键/值
 *      hashMap: 多线程集合，线程较不安全，速度快,可以存储null键/值
 *
 *     方法：
 *       put(k,v)添加元素
 *       get(k)根据k获取元素
 *       remove(k)根据k删除元素
 *       containsKey(k)是否包含k
 *       keySet()，获取集合中的key，存储到set集合中
 *
 */
public class DemoMain {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        System.out.println( map.get("a"));
        System.out.println(map.containsKey("a"));
        //遍历map方式一:使用keySet()方法，获取key的集合，再遍历key集合，获取value值
        Set<String> keySet = map.keySet();
        for (String k : keySet) {
            System.out.print(k+":");
            System.out.print(map.get(k)+" ");

        }
        System.out.println();
        //遍历map方式二：通过entrySet()方法，获取k/v键值对对象的set集合
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.print(entry+" ");
        }
        System.out.println();

        System.out.println(map);
        System.out.println("==========================");
        //创建linkedHashMap集合，底层是哈希+链表结构：双线链表保证迭代的顺序
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", "a");
        linkedHashMap.put("b", "b");
        linkedHashMap.put("c", "c");
        System.out.println(linkedHashMap);

    }

}
