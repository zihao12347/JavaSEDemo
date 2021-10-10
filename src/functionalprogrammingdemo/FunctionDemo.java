package functionalprogrammingdemo;

import java.util.function.Function;

/**
 *function<T,S>接口:根据一个类型的数据得到另一个类型的数据，
 *       抽象方法：
 *          1.apply(T t)根据类型T的参数获取R类型的结果，主要用于类型转化
 *        默认方法
 *          2.andThen()组合多个接口进行操作
 *
 *
 */
public class FunctionDemo {
    /**
     * 使用function<T,R>接口的apply(T t)方法将T类型的数据转换成R类型的数据
     * 将Integer类型的数据转换成String类型的数据
     * @param num
     * @param function
     * @return
     */
    public static String method(Integer num,Function<Integer,String>function){
        return function.apply(num);
    }

    /**
     * function接口的：andThen()方法，多个接口组合操作
     *      将String类型的“123”转换成Integer类型，再把转换后的结果+10，得到结果后，再转换成String类型的数据
     * @param num
     * @param function1
     * @param function2
     * @return
     */
    public static String andThen(String num,Function<String,Integer>function1,Function<Integer,String>function2){
        return function1.andThen(function2).apply(num);
    }

    /**
     * function接口的测试：
     *  String str = "赵丽颖,20";
     *  1. 将字符串截取数字年龄部分，得到字符串；
     * 2. 将上一步的字符串转换成为int类型的数字；
     * 3. 将上一步的int数字累加100，得到结果int数字。
     * @return
     */
    public static int test(String str,Function<String,String> function1,Function<String,Integer>function2,Function<Integer,Integer>function3){

        return function1.andThen(function2).andThen(function3).apply(str);
    }
    public static void main(String[] args) {
        String s = method(102, (num) -> {
            return String.valueOf(num);
        });
        //System.out.println(s);
        String test = andThen("123", (str) -> {
            int num = Integer.parseInt(str);
            return num + 10;
        }, (i) -> {
            return String.valueOf(i);
        });
        //System.out.println(test);
        String str = "赵丽颖,20";
        int i = test(str, (z) -> {
            return z.split(",")[1];//获取第二个元素年龄
        },(age)->{
            return Integer.parseInt(age);
        },(iage)->{
            return iage+=100;
        });
        System.out.println(i);
    }
}
