package streamdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoArrayListNames {
    public static void main(String[] args) {
        ArrayList<String> one = one();
        //1.只要名字为长度为3的成员
        //2.筛选之后的质只要前3人,存储到一个新集合中
        Stream<String> stream1 = one.stream().filter((o) -> {//filter()方法过滤筛选
            return o.length() == 3;
        }).limit(3);//limit()取前三人
        //存储到一个新集合中

        /**
         * 3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
         * 4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
         * 5. 将两个队伍合并为一个队伍；存储到一个新集合中。
         */
        ArrayList<String> two = two();
        Stream<String> stream2 = two.stream().filter((t) -> {
            return t.startsWith("张");
        }).skip(2);//skip()方法跳过前几个

        Stream.concat(stream1, stream2)//组合两个流对象
                .map((name)->{//使用map方法将一个流中的元素映射到另一个流中
            return new Person(name);
        }).forEach((p)->{
            System.out.println(p);
        });

    }

    public static ArrayList<String> one() {
        //第一支队伍
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("迪丽热巴");
        arrayList.add("宋远桥");
        arrayList.add("苏星河");
        arrayList.add("石破天");
        arrayList.add("石中玉");
        arrayList.add("老子");
        arrayList.add("庄子");
        arrayList.add("洪七公");
        return arrayList;
    }

    public static ArrayList<String> two() {
        //第二支队伍
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("古力娜扎");
        arrayList1.add("张无忌");
        arrayList1.add("赵丽颖");
        arrayList1.add("张三丰");
        arrayList1.add("尼古拉斯赵四");
        arrayList1.add("张天爱");
        arrayList1.add("张二狗");
        return arrayList1;
    }
}
