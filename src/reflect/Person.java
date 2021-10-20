package reflect;

public class Person {
    private String name;
    private int age;

    public String address;
    public int gender;

    public Person() {
    }

    public Person(String name, int age, String address, int gender) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public void test(String s){
        System.out.println(s);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
