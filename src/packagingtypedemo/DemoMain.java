package packagingtypedemo;

/**
 * 包装类：
 *      1.java中有两种类型系统：基本类型，引用类型
 *            基本类型数据：使用非常方便，但是没有对应方法操作这些数据
 *            包装类：将基本类型的数据包装起来，再在包装类中定义一些方法，去操作这些基本类型的数据
 *      2.装箱与拆箱：
 *          装箱：将基本类型转换成包装类型对象
 *              2.1构造方法装箱：new Integer(value);
 *              new 包装类型(value);
 *              2.2静态方法装箱：Integer.ValueOf(value);
 *              包装类型.ValueOf(value);
 *          拆箱：将包装类型对象，转换成基本类型:intValue();
 *              基本类型Value();
 *      3.自动装箱与拆箱：基本类型的装箱与拆箱操作在JDK5(jdk1.5)之后能自动完成
 *
 *      4.基本类型与字符串类型之间的转化：
 *          除了Character类之外，其他所有包装类都有parseXxx()方法，将字符串参数转化为对应的基本类型
 *              parseInt(String s);
 *              parseByte(String s)
 *              parseBoolean(String s)
 *              ...
 */
public class DemoMain {
    public static void main(String[] args) {
        //装箱：将基本类型转换成包装类型对象
        Integer integer1 = new Integer(5);//构造方法装箱
        System.out.println(integer1);
        Integer integer2 = Integer.valueOf(10);//静态方法装箱
        System.out.println(integer2);
        //拆箱:将包装类型对象转换成基本类型
        int intValue = integer2.intValue();
        System.out.println(intValue);

        //自动装箱与拆箱
        Integer i1=15;//自动装箱：Integer i1=new Integer(15)
        System.out.println(i1);
        int i2=i1+5;//int i2=i1.intValue()+5;
        System.out.println(i2);

        //基本类型与字符串之间的转换；
        String s1="1000";
        String s2="true";
        //使用包装类的parseXxx()方法，将字符串参数转换成对应的基本类型；
        System.out.println(Integer.parseInt(s1));//将字符串“1000”通过包装类的parseInt()方法转换成int基本类型
        System.out.println(Boolean.parseBoolean(s2));//使用parseBoolean()方法，将字符串转换成boolean基本类型

    }
}
