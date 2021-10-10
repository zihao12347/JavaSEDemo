package functionalprogrammingdemo;

import java.util.Arrays;
import java.util.function.Consumer;

/**import java.util.function.Consumer<T>接口是与supplier接口正好相反，
 *      它是一个消费类型的接口，数据由泛型决定，
 *      comsumer接口中包含一个accept(T t)方法，表示消费一个指定泛型的数据，
 *
 *      comsumer接口是一个消费类型的接口，泛型执行什么类型，accept就消费什么类型的数据
 *      至于如何消费，需要自定义（如输出，计算）
 *
 *     方法：
 *          抽象方法：accept(T t)消费指定泛型的数据
 *          默认方法：andThen() 两个接口的组合操作，把两个接口组合在一起，再对数据进行操作
 *
 */
public class ConsumerDemo {

    /**定义一个方法，方法的参数传递一个字符串的名字
     * 方法的参数传递consumer接口，泛型使用String类型
     * 可以使用consumer接口消费消费字符串名字
     * @param name
     */
    public static void consumeString(String name,Consumer<String> consumer){//方法传递consumer接口，指定String类型
        consumer.accept(name);//accept()方法消费字符串类型的数据
    }

    /**
     * 组合操作多个consumer接口，
     *      传递一个String类型的数据，两个consumer函数式接口
     */
    public static void andThenCon(String s,Consumer<String> consumer1,Consumer<String> consumer2){
        consumer1.andThen(consumer2).accept(s);//组合操作，两个consumer接口，消费字符串类型的s数据

    }
    //打印测试
    public static void test(String[] strs,Consumer<String> consumer1,Consumer<String> consumer2){
        for (String str : strs) {//遍历集合中的String数据，用于操作
            consumer1.andThen(consumer2).accept(str);//遍历每个string类型的元素
        }

    }
    public static void main(String[] args) {
        //调用consumerString()方法，传递一个字符串名称，和lambda表达式作为方法的Consumer接口参数传递
        String name="张三";
        consumeString(name,(s)->{
            //System.out.println(s);//消费方式直接输出
            StringBuffer reverse = new StringBuffer(s).reverse();
            //System.out.println(reverse);//消费方式字符串的反转
        });
        //调用andThenCon()方法，组合消费
        andThenCon("Hello World!", (s1)->{
            //System.out.println(new StringBuffer(s1).reverse());
        }, (s2)->{
            //System.out.println(s2.toLowerCase());
        });
        //打印测试
        String[] strs={"李四,男","牛翠华,女","王二狗子,男"};
        test(strs, (strs1)->{ ;

            /**以,逗号进行分割，返回的是一个数组，
             *split(String regex) 按照指定regex分割符，拆分成多个元素，返回一个数组
             * {"张三,19"}==>[张三,19]
             */
            System.out.print("name:"+strs1.split(",")[0]);//获取第一元素，name
        }, (strs2)->{
            String s = strs2.split(",")[1];//获取第二个元素gender
            System.out.println("gender:"+s);
        });
    }
}
