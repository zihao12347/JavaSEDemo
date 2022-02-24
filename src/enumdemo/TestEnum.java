package enumdemo;

/**
 * @Author yanghao
 * @Date 2022/2/23 16:59
 */

public class TestEnum {
    public enum Sex{
        //内部类中定义一个枚举
        male,female
    }

    public static void main(String[] args) {
        compare(Sex.valueOf("male"));
    }
    public static void compare(Sex sex){
        for (int i = 0; i <Sex.values().length ; i++) {
            //compareTo()方法比较两个枚举在定义时的顺序
            System.out.println(sex+"与"+Sex.values()[i]+"的比较结果是："+sex.compareTo(Sex.values()[i]));
            //ordinal()方法获取枚举成员的索引
            System.out.println("索引"+Sex.values()[i].ordinal()+"，值："+Sex.values()[i]);
        }
    }

}
