package listcollectiondemo;

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
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
