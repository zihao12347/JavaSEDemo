package anonymousdemo;

import java.util.Scanner;

public class AnonymousTest01 {
    public static void main(String[] args) {
        //1.创建匿名对象：只需要scanner对象使用一次：使用匿名对象
        //int nextInt = new Scanner(System.in).nextInt();//获取输入的int值
        //System.out.println(nextInt);

        //2.使用匿名对象作为方法的参数进行传递：调用methodParam对象，使用匿名对象进行传递
        //methodParam(new Scanner(System.in));

        //3.使用匿名对象作为方法的返回值，返回
        int nextInt = methodReturn().nextInt();
        System.out.println(nextInt);
    }

    public static void methodParam(Scanner scanner){
        int nextInt = scanner.nextInt();
        System.out.println(nextInt);
    }

    public static Scanner methodReturn(){
        return new Scanner(System.in);//直接返回匿名对象，
    }

}
