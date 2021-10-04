package staticdemo;

/**
 * static关键字：可以用来修饰成员变量，成员方法，被static修饰的成分是属于类，不再是单属于对象。
 *
 * 类变量：
 *  当static修饰的的成员变量，称为：类变量。
 *  该类所有实例化的对象都可以共享该类变量的值，
 *
 */
public class StatisPropertiesTest01 {
    public static void main(String[] args) {
        Student student01 = new Student("张三",19);
        student01.classRoom="移动互联1902";
        System.out.println(student01+student01.classRoom);
        Student student02 = new Student("李四",22);
        System.out.println(student02+student02.classRoom);
    }
}
