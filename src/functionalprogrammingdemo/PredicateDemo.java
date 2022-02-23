package functionalprogrammingdemo;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate<T>接口：用于对某种数据类型进行判断，返回一个boolean值
 *      方法：
 *          抽象方法：
 *              1.test(T t)用于条件判断，返回一个boolean值
 *          默认方法：有条件判断，就会有与或非三种逻辑关系
 *              2.and()将两个条件使用“与”逻辑连接
 *              3.or()将两个条件使用“或”逻辑关系连接
 *              4.negate()将取“非”关系连接
 *
 */
public class PredicateDemo {
    //判断字符串长度是否大于5
    public static boolean checkString(String s,Predicate<String> predicate){
        return predicate.test(s);//调用test()方法，进行判断
    }
    //判断一个字符串的长度是否大于5，并且是否包含a字符；
    public static boolean andTest(String s,Predicate<String> predicate1,Predicate<String> predicate2){
        return predicate1.and(predicate2).test(s);//使用and()方法对两个predicate接口进行与连接，test()方法与进行判断
    }
    //判断一个字符串的长度是否大于5或是否包含a字符；
    public static boolean orTest(String s,Predicate<String> predicate1,Predicate<String> predicate2){
        return predicate1.or(predicate2).test(s);//使用or()方法对两个predicate接口进行或连接，test()方法或进行判断
    }
    //判断字符串的长度是否大于5，当大于5的时候返回false,当小于5的时候返回true
    public static boolean negateTest(String s,Predicate<String> predicate){
        return predicate.negate().test(s);//使用negate()方法，进行取非判断；
    }

    /**
     * 数组中有多个姓名+性别的消息,将符合要求的的信息，保存到一个新的arrayList数组中
     * 1.必须为女生，2.名字长度必须大于等于4 同时满足这两个条件
     * @return
     */
    public static List<String> test(String[] arr, Predicate<String> predicate1, Predicate<String> predicate2){
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {//遍历数组中的元素进行条件判断
            boolean b = predicate1.and(predicate2).test(s);
            if (b) {
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        List<String> list = test(array, (s) -> {
            return s.split(",")[0].length() ==4;
        }, (s) -> {
            return "女".equals(s.split(",")[1]);
        });
        for (String s : list) {
            System.out.println(s);
        }


        //调用checkString方法，传递String类数据，和lambda表达式
        boolean b1 = checkString("abcd", s ->
            s.length() > 5//判断字符串的长度是否大于5
        );
        //System.out.println(b1);

        boolean b2 = andTest("abcdefg", (s) -> {
            return s.length() > 5;
        }, (s) -> {
            return s.contains("a");
        });
        //System.out.println(b2);

        boolean b3 = orTest("bcdefg", (s) -> {
            return s.length() > 5;
        }, (s) -> {
            return s.contains("a");
        });
        //System.out.println(b3);
        boolean b4 = negateTest("fasd", (s) -> {
            return s.length() > 5;
        });
        //System.out.println(b4);
    }
}
