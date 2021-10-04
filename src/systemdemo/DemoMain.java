package systemdemo;

import java.util.Arrays;
import java.util.List;

/**
 * system类：获取与系统相关的信息或系统级操作处理
 *      1.currentTimeMillis方法：获取当前毫秒值
 *      2.arraycopy(源数组，起始位置，目标数组，起始位置，复制元素个数)
 */
public class DemoMain {
    public static void main(String[] args) {
        //获取当前毫秒值
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
       // demo1();
        int[] array1={1,2,3,4,5,6,7};
        int[] array2=new int[6];
        System.arraycopy(array1, 0, array2,0,3);
        List<String> list = Arrays.asList(Arrays.toString(array2));
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(Arrays.toString(array2));
    }

    /**
     * 使用currentTimeMillis方法测试程序运行效率
     */
    public static void demo1(){
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i <999 ; i++) {
            System.out.println(i);
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        long l = currentTimeMillis1 - currentTimeMillis;
        System.out.println("程序一共耗时:"+l);
    }
}
