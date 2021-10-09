package functionalprogrammingdemo.logdemo;

/**
 * 日志案例：只有当日志级别为1的时候，打印输出日志信息，
 *        那么当日志级别为其他的时候，则不会打印已经拼接好的日志信息，从而造成性能浪费
 *     在有些场景代码执行后，结果并没有使用到，此时就造成了性能的浪费，
 *     而lambda表达式是延迟执行的，正好可以使用这一点作为解决方案，提高性能
 *
 */
public class DemoLogger {
    //定义一个根据日志级别，显示日志消息的方法
    public static void showLog(int level,String message){
        //对日志等级进行判断，如果是1级别，那么输出日志信息
        if (level==1) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        //定义三个日志级别信息
        String msg="Hello";
        String msg2="World";
        String msg3="Java";
        //调用showLog()方法，传递日志级别和日志信息
        showLog(2,msg+msg2+msg3);

    }
}
