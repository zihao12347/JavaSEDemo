package staticdemo;

public class Student {
    private int id;//实现id自动生成
    private String name;
    private int age;
    static String classRoom;
    private static int countId=0;//共享计数器，因为它先于对象，能被对象共享

    /**
     * 在无参构造方法中实现，id自动生成，不传参实例化对象的时候，是默认调用无参构造方法的，
     * 然后让countId++
     */
    public Student() {
        this.id=++countId;//id先从默认0值，++变成1
    }

    /**
     * 在全参构造方法中也要实现，传参实例化对象的时候，调用全餐构造方法
     * a=++b    先运算再赋值
     * a=b++    先赋值再运算
     *
     * @param name
     * @param age
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id=++countId;//先从默认0值，++变成1
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
