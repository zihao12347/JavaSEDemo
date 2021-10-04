package anonymousdemo;

/**
 * 匿名对象：只有创建的语句，并没有把对象的地址赋值给某个变量
 * 匿名对象：没有变量名称的对象
 * 使用场景：只需要使用唯一一次的对象，就可以使用匿名对象。
 */
public class Anonymous {
    public static void main(String[] args) {
        //1.实例化对象
        Persion persion = new Persion();
        persion.name="高圆圆";
        persion.showName();
        //2.创建匿名对象
        new Persion().name="小王";
        new Persion().showName();
    }
}
