package listcollectiondemo;

import java.util.LinkedList;

/**
 *  LinkedList: 底层是链表结构，增删慢，查询快，
 *      实际开发中，对LinkedList元素，经常涉及到首尾的操作
 *      push/add 新增元素
 *      remove/pop 删除元素
 *
 *      addFist() 在集合的开头新增元素
 *      addLast() 在集合的结尾新增元素
 *      getFirst() 获取集合中第一个元素
 *      getLast() 获取集合在末尾元素
 */
public class LinkedListDemoMain {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("abc");
        linkedList.push("efg");//push等同于add()方法，

        linkedList.addFirst("www");//addFirst()在集合的开头新增元素
        linkedList.addLast(".com");//在集合的结尾新增元素
        System.out.println(linkedList.getFirst());//获取集合中第一个元素
        System.out.println(linkedList.getLast());//获取集合中末尾的元素


        System.out.println(linkedList);


    }
}
