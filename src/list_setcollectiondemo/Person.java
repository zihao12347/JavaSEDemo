package list_setcollectiondemo;

import java.util.Objects;

/**
 * 使用Collecions工具类的sort()方法，要想实现排序，那么元素就必须实现Comparable接口
 * 并且重写compareTo()方法，定义排序规则
 */
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     *重写comparable接口中CompareTo()方法，定义排序规则
     *排序规则：
     *      this-o(传递过来的参数) 升序
     *      o-this 降序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Person o) {
        return this.getAge()-o.getAge();//根据年龄，按照升序排序
    }

    /**
     * HashSet集合要保证集合中的元素不重复，
     *  那么该集合中的元素就必须重写hashCode()与equals方法，
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person persion = (Person) o;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
