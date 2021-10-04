package extendsdemo;

/**
 * 继承：子类可以继承父类非私有的行为和属性， A extends B
 *    优点：1.提高代码的复用性
 *          2.类与类之间产生了关系，是多态的前提
 *
 */
public class Demo01Extends   {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.test(3);
        teacher.call();//子类继承父类公共的方法
    }

}
