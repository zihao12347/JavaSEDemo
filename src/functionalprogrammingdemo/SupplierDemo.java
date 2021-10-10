package functionalprogrammingdemo;

import java.util.function.Supplier;

/**常用的函数式接口:
 *      Supplier<T>接口：仅包含一个无参抽象方法，被称之为生产类型的接口
 *          指定接口泛型是什么类型，get()方法就获取什么类型数据
 *
 *
 */
public class SupplierDemo {
    public static String getString(Supplier<String> supplier){
        String data = supplier.get();//get()获取指定类型的对象数据
        return data;
    }

    public static void main(String[] args) {
        String s="abcd";
        System.out.println(getString(()->{return s;}));//使用lambda表示作为方法参数传递
        System.out.println("=======================================================");
        int[] ints={-89,0,9,65,3515};
        //通过lambda表达式求int[]数组的最大元素值
        int maxInt= getMax(() -> {
            int max = ints[0];
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] > max) {
                    max = ints[i];
                }
            }
            return max;
        });
        System.out.println(maxInt);

    }

    public static int getMax(Supplier<Integer> nums){
        return  nums.get();//使用get()方法获取指定类型的对象数据
    }
}
