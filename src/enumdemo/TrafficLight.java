package enumdemo;

/**
 * @Author yanghao
 * @Date 2022/2/23 16:35
 */
enum Signal{
    //定义一个枚举类型
    GREEN,YELLOW,RED
}
public class TrafficLight {
    //通过枚举名称直接使用枚举成员
    static Signal color=Signal.RED;

    public void getColor(){
        //通过switch语句可观性更强
        switch (color){
            case GREEN:
                color=Signal.RED;
                System.out.println(color);
                break;
            case YELLOW:
                color=Signal.YELLOW;
                System.out.println(color);
                break;
            case RED:
                color=Signal.GREEN;
                System.out.println(color);
                break;
        }
    }

    public static void main(String[] args) {
        new TrafficLight().getColor();
        //values()方法获取枚举的所有成员
        for (int i = 0; i <Signal.values().length ; i++) {

            System.out.println("枚举成员"+Signal.values()[i]+Signal.values()[i]);
        }

    }
}
