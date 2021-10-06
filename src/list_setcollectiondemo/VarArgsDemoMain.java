package list_setcollectiondemo;

/**
 *可变参数：方法需要接收多个参数，并且参数类型一致
 *       前提：
 *          参数类型确定，但是参数个数不确定
 *      格式：
 *          访问修饰符 返回值 方法名(参数类型...参数名称)//
 *          访问修饰符 返回值 方法名(参数类型[] 参数名称){
 *
 *          }
 *      原理：
 *          可变参数底层是一个数组，数据传递参数个数不同，会创建不同长度的数组，来存储这些参数
 *          传递的参数可以是0个，或者多个
 *      注意事项：
 *          1.一个方法中只有一个可变参数列表；
 *          2.方法中，有多个参数是，可变参数只能位于最后
 */
public class VarArgsDemoMain {
    public static void main(String[] args) {
        int add = add(1, 2);
        System.out.println(add);
        int addThree = addThree(1, 2, 3);
        System.out.println(addThree);
        int addN = addN(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(addN);

    }
    public static int add(int a,int b){
        return a+b;
    }
    public static int addThree(int a ,int b, int c){
        return a+b+c;
    }

    /**
     * 要求：方法的参数类型确定，但是方法的参数个数不确定。
     * 解决方案，此时就可以使用可变参数来实现
     * @return
     */
    public static int addN(int...agrs){
        int sum=0;
        for (int agr : agrs) {
            sum=sum+agr;
        }
        return sum;
    }
}
