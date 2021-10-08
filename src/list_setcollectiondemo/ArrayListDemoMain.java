package list_setcollectiondemo;

import java.util.ArrayList;

/**
 * List集合：
 *      特点：有序(元素存储和取出顺序一致),有索引，可重复，
 *      类别：
 *      ArrayList: 底层是数组实现，查询快，增删慢。

 *          add() 新增
 *          get() 获取
 *          remove() 去除
 *          clear() 清空
 *          set() 重置
 */
public class ArrayListDemoMain {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("abcd");
        arrayList.add("efg");
        System.out.println(arrayList.get(1));
        arrayList.set(1, "efgh");
        arrayList.remove("efgh");
        arrayList.clear();
    }
}