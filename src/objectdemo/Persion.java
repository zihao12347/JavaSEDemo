package objectdemo;

import java.util.Objects;

public class Persion {
    private String name;
    private int age;

    public Persion() {
    }

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
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


    //重写Object()类的equals方法：将对象的属性值进行比较
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persion)) return false;
        Persion persion = (Persion) o;
        return getAge() == persion.getAge() &&
                Objects.equals(getName(), persion.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    /**
     * 重写toString()方法；将对象的属性以字符串形式表示出
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
