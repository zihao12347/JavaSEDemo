package list_setcollectiondemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * java.util.Collections:是集合的工具类，用来对集合进行操作，
 *    addAll() 向集合中添加一些参数
 *    shuffle() 打乱集合顺序.
 *    sort(list) 排序，默认升序排序
 *      使用sort()排序方法,集合中的元素必须实现comparable接口，重写compareTo方法定义排序规则
 *    sort(list,comparator)按照指定规则排序
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        //使用Collections工具类的addAll()方法，向指定集合中添加一些元素
        Collections.addAll(arrayList, "f","g","h","i","j");
        System.out.println(arrayList);
        //使用Collections工具类的shuffle()方法，打乱集合
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);

        ArrayList<Person> personArrayList = new ArrayList<>();
        Person p1 = new Person("张三",19);
        Person p2 = new Person("李四",20);
        Person p3 = new Person("王五",26);
        Person p4 = new Person("邓六",13);
        Collections.addAll(personArrayList, p1,p2,p3,p4);//添加一些元素
        Collections.sort(personArrayList);//排序方法
        System.out.println(personArrayList);
        /**
         * sort(list,comparator),按照comparator指定排序方式，排序
         */
        Collections.sort(personArrayList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().charAt(0)-o2.getName().charAt(0);//按照姓名升序排序
            }
        });
        System.out.println(personArrayList);
    }
}
