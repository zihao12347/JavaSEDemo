package stringbuilderdemo;

/**
 * String：字符串是一个常量，值在创建后不可被更改。
 *      字符串的底层是一个被final修饰的字节数组，
 *
 * StringBuilder：是一个可变字符串序列，类似字符串的字符串的缓冲区，
 *          append()方法：添加任意类型数据的字符串，并返回当前对象本身
 *          toString()方法：将当前StringBuilder对象转化成String类型的对象
 *
 * StringBuffer:StringBuffer和StringBuilder类似，
 *              每次在操作字符串时，都是对字符串本身进行操作，而不是新增对象
 *              区别：
 *              StringBuffer线程相对于安全：
 *              StringBuilder速度较快，在对字符串进行修改的时候一般使用stringBuilder对象
 */
public class DemoMain {
    public static void main(String[] args) {
        StringBuffer stringBuffer1 = new StringBuffer("abc");
        //添加任意类型数据的字符串，并返回当前对象本身
        StringBuffer stringBuffer2 = stringBuffer1.append("efg");
        System.out.println(stringBuffer1);
        System.out.println(stringBuffer2);
        System.out.println(stringBuffer1==stringBuffer2);//true:表示是对字符串本身进行操作
        String s = stringBuffer2.toString();
        System.out.println(s);//StringBuilder对象转换成string
    }
}
