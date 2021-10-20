package multidemo;

/**
 * 多态：同一种行为，具有多种不同的表现形式
 *      前提：1.类的继承/接口的实现 2.方法的重写 3.父类引用指向子类对象(格式)
 *
 *      格式; 父类名称 对象名=new 子类名称();
 *
 *        访问成员变量的两种方式：
 *            1.通过对象直接访问：优先访问等号左边的对象的成员变量，没有则向上找
 *            2.通过成员方法间接访问：方法属于谁，就优先用谁，没有则向上找
 *        访问成员方法：
 *            new是那个对象，优先使用该对象，没有则向上找
 *     优势：提高代码的扩展性和便利性
 *
 *     多态中的类型转化：
 *          向上转： 父类类名 变量名=new 子类类名()
 *              父类引用指向子类对象，默认的转化；安全转化
 *              只能调用子类重写方法，或者父类特有方法
 *          向下转： 子类类名 变量名=(子类类名) 父类变量名称，强制转化
 *               只能调用子类重写方法，或者是子类特有方法
 *
 *      object o instanceof Class c关键字：
 *          指出o对象是否是c特定类的一个实例
 */
public class DemoOneMulti {
    public static void main(String[] args) {
        //使用多态，父类引用指向子类对象
        Fu multi=new Zi();//默认向上转化
        System.out.println("===================访问成员变量=====================");
        int num = multi.num;//访问成员变量，优先使用等号左边对象的成员变量
        System.out.println(num);
        multi.showNum();//通过成员方法间接访问成员变量

        System.out.println("====================访问成员方法====================");
        multi.method();//父子类都有该方法，使用的是new的那个对象的方法
        multi.methodFu();//new的那个对象的方法，没有，则向上找，找到父类中有

        Zi zi=(Zi) multi;//向下转化，强制转化
        zi.test();//调用子类特有方法

        //instanceof关键字：指出一个对象是否为特点类的一个实例
        boolean b = multi instanceof Fu;
        System.out.println(b);
    }
}
