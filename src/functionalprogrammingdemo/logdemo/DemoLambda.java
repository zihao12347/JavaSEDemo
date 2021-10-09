package functionalprogrammingdemo.logdemo;

import java.sql.SQLOutput;

/**
 * Lambda表达式
 *      前提：必须包含一个函数式接口（该接口中有且仅有一个抽象方法）
 *      特点：延迟加载
 *   使用lambda表达式的延迟加载的特点可以解决日志案例的性能浪费
 *   思路：
 *       使用lambda表达式作为参数的传递，仅仅只是把参数传递到了showMessage()方法中，
 *       只有当满足level为1的条件时候，才会调用builderMessage()方法，进行字符串拼接
 *       如果level条件不满足的时候，就不会执行builderMessage()方法，进行字符串拼接
 *
 */
public class DemoLambda {
    public static void showMessage(int level,MessageBuilder message){//函数式接口通常作为方法的参数或者返回值使用
        if (level == 1) {
            System.out.println(message.builderMessage());//钓鱼builderMessage()方法进行字符串拼接
        }

    }
    public static void main(String[] args) {
        //定义三个日志级别信息
        String msg="Hello";
        String msg2="World";
        String msg3="Java";

        showMessage(3, ()->{
            System.out.println("不满足条件");//测试是否不满足条件时候，还会调用builderMessage()方法进行字符串拼接
            return msg+msg2+msg3;
        });
    }
}
