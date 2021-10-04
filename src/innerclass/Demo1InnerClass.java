package innerclass;

import sun.plugin2.message.Message;

import java.sql.SQLOutput;

/**
 * 内部内：一个类中包含另一个类
 *   分类：
 *      1.成员内部类：定义在类中
 *   使用：
 *      内用外:
 *          随意使用，
 *         注意：当内部类和外部类中有重名的属性和方法时，通过:” 外部类名.this.成员变量 “格式访问
 *
 *      外用内:先定义内部类对象
 *         创建内部类对象格式:
 *              外部类名.内部类名 对象名称=new 外部类().new 内部类()
 *      局部内部类(匿名内部类): 定义在方法中：
 *         使用：只能在方法中进行访问局部内部类，
 *
 */
public class Demo1InnerClass {//外部内

    public class InnerClassOne {//成员内部类
        public int num = 20;
        public void methodInner() {
            System.out.println(num);
            System.out.println(Demo1InnerClass.this.num);//通过外部类.this.成员变量格式访问重名的变量
            System.out.println("内部类方法！" + "直接访问外部类成员变量" + num);
        }
    }

    public int num = 10;

    public void methodOuter() {
        System.out.println("外部类方法！");
        class InnerTwo{//局部内部类
            public void methodInnerTwo(){
                System.out.println("我是局部内部类！");
            }
        }
        InnerTwo innerTwo = new InnerTwo();
        innerTwo.methodInnerTwo();//通过局部内部类对象访问局部内部类中的成员方法
    }

    /**
     * 外部类使用内部类方法
     * @param args
     */
    public static void main(String[] args) {
       //1.创建内部类格式： 外部类名.内部类名 对象名称= new 外部类().new 内部类;
        Demo1InnerClass.InnerClassOne innerClassOne=new Demo1InnerClass(). new InnerClassOne();
        //2.通过内部类对象，访问内部类
        innerClassOne.methodInner();
        Demo1InnerClass innerClass = new Demo1InnerClass();
        innerClass.methodOuter();
    }
}
