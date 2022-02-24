package enumdemo;

/**
 * @Author yanghao
 * @Date 2022/2/23 17:19
 */
enum WeekDay{

    //枚举项使用枚举的构造方法；枚举("args")
    Mon("Monday"),Tue("Tuesday"),Wed("Wednesday"),Thu("Thursday"),Fri("Friday"),Sat("Saturday"),Sun("Sunday");
    private final String day;

    /**
     * 创建枚举构造器,必须先定义枚举，再使用分号隔开
     * @param day
     */
    private WeekDay(String day){
        this.day=day;
    }

    public static void printDay(int i){
        switch (i){
            case 1:
                System.out.println(WeekDay.Mon);
                break;
            case 2:
                System.out.println(WeekDay.Tue);
                break;
            case 3:
                System.out.println(WeekDay.Wed);
                break;
            case 4:
                System.out.println(WeekDay.Thu);
                break;
            case 5:
                System.out.println(WeekDay.Fri);
                break;
            case 6:
                System.out.println(WeekDay.Sat);
                break;
            case 7:
                System.out.println(WeekDay.Sun);
                break;
            default:
                System.out.println("wrong number!");
        }

    }

    public String getDay() {
        return day;
    }
}
public class TestConstrEnum {
    public static void main(String[] args) {
        for (WeekDay weekDay : WeekDay.values()) {
            System.out.println(weekDay+"========>"+weekDay.getDay());
        }
        WeekDay.printDay(3);
    }
}
