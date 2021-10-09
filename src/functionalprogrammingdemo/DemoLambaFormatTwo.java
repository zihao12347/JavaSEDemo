package functionalprogrammingdemo;



import java.util.Arrays;
import java.util.Comparator;

/**
 * 使用lambda有返回值和有参数的格式:
 *      需求：使用数组存储多个person对象，
 *          对数组中的person对象使用arrays的sort()方法通过年龄进行升序排序
 */
public class DemoLambaFormatTwo {

    public static void main(String[] args) {
        Person[] persons={new Person("张三",19),new Person("李四",23),
                new Person("王五",31),new Person("老六",14),};
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();//升序排序
            }
        });
        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println("========================================");
        //参数类型Person可省略
        Arrays.sort(persons,( o1,  o2)->{
            return o2.getAge()-o1.getAge();//降序排序
        });
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("========================================");

        //lambada表达式有参数有返回值的练习
        //当方法体中只有一行代码，return关键字，分号，{}大括号都可以省略
        invokecal(120,130 , (num1,num2)->
             num1+num2
        );

    }

    /**
     * 定义一个方法：
     *      传递两个int类型的参数，进行计算
     *      传递calculator接口，调用该接口的cal()计算方法，将两个int类型的参数进行计算
     * @return
     */
    public static void invokecal(int num1,int num2,Calculator calculator){
        int cal = calculator.cal(num1, num2);
        System.out.println(cal);
    }
}
