package functionalprogrammingdemo;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 使用lambda表达式作为参数或者返回值：
 *      java中的lambda表达式可以被当作是一个匿名内部类的替代品，简化冗余的代码，
 *      如果方法的参数是函数式接口，那么就可以通过lambda进行替代，
 *      lambda表示作为方法的参数，也就是函数式接口作为方法的参数
 *
 */
public class lambdaAsArgOrPar {
    /**
     * 函数式接口作用方法的参数来使用
     * runnable接口本来也就是一个函数式接口
     * @param runnable
     */
    public static void invokeMethod(Runnable runnable){
        new Thread(runnable).start();
    }

    /**
     * 方法的返回值是一个函数式接口
     * @return
     */
    public static Comparator<String> CreateComparator(){
        return (o1,o2)->{
            return o1.length()-o2.length();//字符串长度升序排序
        };//使用lambda表达式作为返回值
    }
    public static void main(String[] args) {
        //使用lambda表达式作为参数使用
        invokeMethod(()->{
            System.out.println(Thread.currentThread().getName()+"lambda表达式作为参数来使用！");
        });

         String s1="java";
        String s2="HelloWord";
        String s3="hi";
        String[] strs={s2,s3,s1};
        System.out.println(Arrays.toString(strs));
        Arrays.sort(strs, CreateComparator());
        System.out.println(Arrays.toString(strs));
    }

}
