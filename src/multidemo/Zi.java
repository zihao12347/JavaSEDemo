package multidemo;

public class Zi extends Fu {
    int num=20;
    /**
     * 子类重写覆盖父类方法
     */
    @Override
    public void method() {
        System.out.println("子类方法！");
    }
    public void test(){
        System.out.println("test！");
    }

}
