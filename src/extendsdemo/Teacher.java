package extendsdemo;

/**
 * 子类：
 * 当子类与父类的属性和方法重名时：
 * 1.属性变量重名时：如何获取
 * 1.1成员变量     this关键字调用子类
 * 1.2局部变量    直接变量名称调用
 * 1.3父类变量    super关键字调用父类变量
 * 2.成员方法重名称----方法的重写:
 * 特点:既沿袭了父类的方法，又对父类方法进行扩展和增强
 * 2.1子类出现父类一模一样的方法时(返回值类型，方法名称，参数列表),出现覆盖的效果--重写
 * ***区别重写--重载
 * 重写：出现在继承中，子类与父类的方法名称，返回值类型，参数列表都一样
 * 重载：方法名称一样：参数个数，顺序，类型都不一样
 *
 * @Override注解：判断方法子类是否重写父类的方法 2.2重复方法的返回值：子类方法返回值必须小于<或等于=父类方法的返回值范围
 * 2.3访问修饰符：子类方法的访问修饰符大于>或等于=父类的访问修饰符
 */
public class Teacher extends Employee {
    int Num;


    /**
     * 继承构造方法的访问特点：
     *      子类构造方法中默认隐含一个super()，先调用父类无参构造方法，后执行子类构造方法
     */
    public Teacher() {
        System.out.println("子类构造方法！");
    }

    @Override
    public void call() {//重写父类方法
        System.out.println("来电头像！*|*");
        super.call();//调用父类方法，提高代码可复用性
        System.out.println("来电姓名!");

    }

    public void test(int num) {
        System.out.println(num);//局部变量
        this.Num = 2;//成员变量
        System.out.println(this.Num);
        super.Num = 1;//父类变量
        System.out.println(super.Num);
    }
}
