package enumdemo;

/**
 * @Author yanghao
 * @Date 2022/2/23 18:02
 */
public class TestAbstracMetEnum {
    enum Season{
        //枚举项使用枚举构造方法
        Spring("春天",1){
            //枚举项实现抽象方法
            @Override
            public void show() {
                System.out.println("");
            }
        },
        Summer("夏天",2) {
            @Override
            public void show() {
                System.out.println("");
            }
        },
        Autumn("秋天",3) {
            @Override
            public void show() {
                System.out.println("");
            }
        },
        Winter("冬天",4) {
            @Override
            public void show() {
                System.out.println("");
            }
        };
        private final String name;
        private final int code;

        /**
         * 构造方法
         * @param name
         * @param code
         */

        Season(String name,int code) {
            this.name=name;
            this.code=code;
        }

        /**
         * 抽象方法
         */
        public abstract void show();

    }

    public static void main(String[] args) {
        System.out.println(Season.Summer);
    }
}
