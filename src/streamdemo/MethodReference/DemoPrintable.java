package streamdemo.MethodReference;

import org.junit.Test;

/**
 * 方法引用"::"：用已经存在的对象直接调用已经存在的方法
 *      注意：lambda传递的传参数，一定是方法引用中的方法可以接收的参数类型，否则会抛出异常
 *
 *
 */
public class DemoPrintable {
    //定义一个方法，参数传递printable接口，对字符串进行打印
    public static void print(Printable p){
        p.print("Hello World!");
    }
    public static void main(String[] args) {
        //调用print()方法，方法参数是Printable接口，所以可以传递lambda表达式
            print((msg -> System.out.println(msg)));
    }

    /**
     * 测试方法的引用：
     *     分析：lambda表达式的目的，打印参数传递的字符串。
     *          把参数msg传递给System.out对象，调用out对象的println()方法，对字符串进行输出
     *     注意：
     *          1.System.out对象已经存在的，
     *          2.println方法也是已经存在，
     *     所以我们可以使用方法引用来优化lambda表达式，
     *     可以使用System.out直接引用println方法
     */
    @Test
    public void testReference(){
        print(System.out::println);
    }
}
