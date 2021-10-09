package lambdademo;

/**使用lambda无参无返回值的格式：
 * 需求：
 *   给定一个厨子Cook接口，内含唯一的抽象方法makeCook,且无参数，无返回值
 *   要求使用lambda表达式调用makecook方法，打印输出“吃饭啦”字样；
 */
public class DemoLambdaFormatOne {
    public static void main(String[] args) {
        //调用invokeCook()方法，参数是cook接口，传递cook接口的匿名内部类对象
        invokeCook(new Cook() {
            @Override
            public void makeCook() {
                System.out.println("吃饭啦！");
            }
        });
        //使用lambda表达式简化匿名内部类的书写！
        invokeCook(()-> System.out.println("吃饭啦!"));
    }
    public static void invokeCook(Cook cook){
        cook.makeCook();
    }
}
