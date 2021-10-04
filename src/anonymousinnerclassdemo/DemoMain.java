package anonymousinnerclassdemo;

/**
 * 匿名内部类：
 *      前提是一个父类的子类或者是接口的实现类，只需使用唯一一次：
 *      格式：new 父类/父接口(){
 *          重写父类中的方法
 *      }
 *
 */
public class DemoMain {
    public static void main(String[] args) {
        new MyInterface(){//匿名内部类
            @Override
            public void method() {//重写/实现方法
                System.out.println("匿名内部类实现重写父接口中的方法！");
            }
        }.method();//调用重写后的方法

    }

}
