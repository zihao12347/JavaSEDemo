package streamdemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流：JDK1.8版本提供的。用于解决集合类库的弊端
 *      Stream流：其实是集合元素的函数模型。Stream流的数据源可以是集合，数组。
 *    特点：
 *          Stream流：属于管道流，只能被使用一次，也就是第一个stream调用了完毕方法，就传到下一个流中，然后第一个流自动关闭
 *    获取流：
 *       1.获collection单例集合的流： stream()方法
 *       2.获取数组流：Stream接口提供的of()方法，
 *       3.获取map集合流：
 *            1.keySet().stream()方法获取map集合key键的流
 *            2.values().stream()方法获取map集合value值的流
 *            3.entrySet().stream()方法获取map集合的entry键值对对象流
 *    常用方法：
 *      2.filter(predicate< ? super t> p)过滤方法。
 *            predicate接口用于条件判断，抽象方法test()进行条件判断，会返回一个boolean值，
 *            当条件满足返回true时，filter()方法会保留元素，否则则弃用该元素
 *      3.map(Function<? super T,? super R> f)映射,将流中的元素映射到另一个流对象中
 *            function<T,S>接口:用于将一种数据类型的得到另一种数据类型的接口,apply(t)抽象方法,用于将指定的T类型转换成另一个类型
 *      4.collect(Collector c)方法:把流中的元素收集到一个集合中
 *          工具类Collectors提供的收集方式:
 *              1.toList()方法,把元素收集到list集合中
 *              2.toSet()方法,把元素收集到set集合中
 *              3.toMap()方法,把元素收集到map集合中
 *      6.limit(int preMax)最多取前几个元素
 *      7.skip(long n)跳过前几个元素
 *      8.concat(Stream a ,Stream b):Stream接口提供的concat(Stream a,Stream b)组合两个流成为一个流
 *      终结操作方法:执行完此方法之后,stream不能再执行其他任何操作
 *      1.forEach(consumer<T t> c)对流中的每个元素进行逐一处理（遍历元素）：
 *             consumer是消费类型的接口，抽象方法accept(T)消费指定类型的对象数据
 *      5.count()方法:返回该流中的元素个数
 *
 *
 *
 */
public class DemoMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.stream()//获取集合对象的流
                .filter((name)->{//过滤判断名字中是否有包含”张“
            return name.startsWith("张");
        }).filter((name)->{//过滤判断名字长度为3
            return name.length()==3;
        }).forEach((l)->{//forEach()方法对每个元素进行逐一处理，输出，
            System.out.println(l);
        });

        String[] arr={"a","b","c"};
        Stream<String> stream = Stream.of(arr);//通过Stream接口的of()方法获取数组的流
        stream.filter((s) -> {
            return s.contains("a");//对数组元素进行过滤，只返回包含a字符的元素
        }).forEach(s -> { System.out.println(s); });

        /**
         * 该stream流被调用完filter(predicate<t>)方法之后,该stream流就自动关闭,只能使用一次
         *  再使用就报错:Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
         *
         */
        //stream.forEach(s -> { System.out.println(s); });
        String[] arr2={"1","2","3"};
        Stream<Object> stream2 = Stream.of(arr2)
                .map((s) -> {return Integer.parseInt(s);});//map()方法将一个流中的元素映射到另一个流中
        List<Object> collect = stream2.collect(Collectors.toList());//collect()方法把流中的结果收集到一个集合中
        //System.out.println(collect);

        long count = Stream.of(1, 2, 3, 4).filter((i) -> {
            return i > 1;
        }).count();//使用count()方法计数方法,该方法是一个终结方法,调用完count()或forEach()方法之后不能再调用其他方法
       //System.out.println(count);
        List<Integer> list1 = Stream.of(1, 2, 3, 4).limit(2)//limit(int preMax)最多取前几个元素
                .collect(Collectors.toList());
        list1.forEach((l)->{
            //System.out.println(l);
        });
        Stream.of(1, 2, 3, 4).skip(2)//skip()方法跳过前几个元素
                .forEach((i)->{
            //System.out.println(i);
        });

        Stream<Integer> stream3 = Stream.of(1, 2, 3);
        Stream<String> stream4 = Stream.of("a", "b", "c");
        Stream<? extends Serializable> concat = Stream.concat(stream3, stream4);//concat(a,b)方法组合两个流成一个流
        concat.forEach((c)->{
            System.out.println(c);
        });
    }
}
