package reflect;

import objectdemo.Persion;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 反射：
 *    反射机制：
 *          在运行状态中，对任意类，都能能知道这个类的所有方法和属性
 *          对任意对象，都能调用它的所有属性和方法；
 *          这种动态获类的信息，和动态调用调用类的方法或属性的功能为反射机制
 *    使用反射的好处：
 *         1.可以在程序运行过程中，操作这些对象；
 *         2.可以降低程序的耦合性。
 *    获取Class类对象的方式：
 *          1.Class.forName("全类名")，将字节码文件加载进内存，返回class对象
 *               多用于加载配置文件，读取配置文件
 *          2.类名.class：通过类名的属性class获取
 *               多用于参数传递
 *          3.对象.getClass():getClass()方法在object类中定义着，
 *               多用于通过对象获取字节码文件
 *    Class类的常用方法：
 *          1.newInstance()方法，创建Class类对象
 *          2.getClassLoader()方法，获取Class类的加载器
 *
 *
 *    结论：
 *          同一个字节码文件(*.class)，无论是通过那种方式获取到的class对象，都是相同的
 *    Class对象功能：
 *       获取功能
 *          1.1获取成员变量：
 *              getFields()：获取所有public修饰的成员变量
 *              getField(String name)；获取指定名称public的成员变量
 *              getDeclaredFields()：获取所有的成员变量，无论访问修饰符
 *              getDeclaredField(String name)：获取指定名称的成员变量,无论访问修饰符
 *          1.2Field成员变量的操作：
 *              get()获取值
 *              set()设置值
 *              setAccessible()忽略访问修饰符的安全检查
 *
 *          2.获取构造方法:
 *              getConstructors()：获取所有的构造方法
 *              Method getMethod(String name, 类<?>... parameterTypes)
 *              Method[] getDeclaredMethods()
 *              Method getDeclaredMethod(String name, 类<?>... parameterTypes)
 *
 *          2.2操作构造方法
 *              newInstance(Object ...innitargs)使用有参构造方法创建对象
 *              new Instance()使用无参构造方法创建对象
 *
 *          3.获取成员方法:
 *              getMethods()：获取public成员方法
 *              getDeclaredMethods():获取任意访问修饰符的方法
 *          3.2操作方法：
 *              invoke()执行方法
 *              getName()：获取类名
 *
 *      反射创建对象：使用反射动态创建类的对象，通过调用一个构造方法实现。
 *          1.无参构造方法：
 *                  通过class对象，调用newInstance()方法直接创建一个对象
 *          2.有参构造方法：
 *                  1).先获取Class对象的构造方法实例，
 *                  2).再通过获取到的构造方法实例，调用newInstance(...)创建实例
 *
 *
 *
 *
 */
public class DemoMain {
    private int i;

    /**
     * 获取Class对象方式：
     *      1.Class.forName("全类名")：将字节码文件加载进内存，返回class对象
     *            多用于加载配置文件
     *      2.类名.class：通过类名的属性class获取
     *            多用于参数的传递
     *      3.对象.getClass()：通过对象获取class类对象
     *
     */
    @Test
    public void testGetClass(){
        //通过Class.forName("全类名")方式获取Class对象
        try {
            Class clas1 = Class.forName("reflect.Person");
            System.out.println(clas1);
            String name = clas1.getName();
            System.out.println(name);
            ClassLoader classLoader = clas1.getClassLoader();
            System.out.println(classLoader);
            Person instance =(Person) clas1.newInstance();
            instance.setName("梓浩");
            System.out.println(instance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        //通过类名.class方式获取Class对象
        Class<Person> cls2 = Person.class;
        System.out.println(cls2);
        //通过对象.getClass()方式获取,class对象
        Person person = new Person();
        Class<? extends Person> cls3 = person.getClass();
        System.out.println(cls3);

        /**
         * 同一个字节码文件无论是通过哪一种方式获取的class对象，都是相同的
         */
        System.out.println(cls2==cls2);
    }

    /**
     * 反射的获取功能：
     *      获取成员变量
     *          getFields()获取public成员变量
     *          getField(String s)获取指定名称的成员变量
     *          getDeclaredFields()获取所有访问符的成员变量
     *          getDeclaredField()获取指定名称的任意任意访问修饰符的成员变量
     *      操作fields成员变量
     *          get(Object o,Object value)根据对象，获取值
     *          set()设置值
     *          setAccessible()设置该属性忽略访问修饰符
     */
    @Test
    public void testProperties() throws Exception {
        Class<? extends Person> personClass = Person.class;//获取Person类的class对象
        Field[] publicFields = personClass.getFields();//getFields()方法获取public成员变量
        for (Field personClassField : publicFields) {
            //System.out.println(personClassField);
        }
        Field[] fields = personClass.getDeclaredFields();//getDeclaredFields()方法获取所有访问符的成员变量
        for (Field field : fields) {
            //System.out.println(field.toString());
        }
    }

    /**
     * 测试操作class对象的属性：
     *        方法：
     *          1.set(Object o,Object value)设置值
     *          2.get(Object o)获取某个对象的属性值
     *          3.setAccessible()设置忽略访问修饰符
     *          newInstance()方法创建对象
     */
    @Test
    public void testOpePro() throws Exception {
        Class<? extends Person> personClass = Person.class;//获取Person类的class对象
        Field addressf = personClass.getField("address");
        Person person = new Person();
        Object value = addressf.get(person);//get()方法获取到person对象中的address属性值
        //System.out.println(value);//默认初始值为null
        addressf.set(person, "北京");//set()方法设置person对象的address成员变量的值
        Object addrvalue = addressf.get(person);
        //System.out.println(addrvalue);
        Field name = personClass.getDeclaredField("name");//获取非public的属性
        name.setAccessible(true);//设置该属性忽略访问修饰符
        System.out.println(name.get(person));
        Person newInstance = personClass.newInstance();//newInstance()方法创建对象
        //System.out.println(newInstance);
    }

    /**
     * 测试获取class的构造方法对象
     *      1.getConstructors()获取所有的public构造方法
     *      2.Method getMethod(String name, 类<?>... parameterTypes)
     *      3.getDeclaredConstructors()获取所有的构造方法
     *      4.Method getMethod(String name, 类<?>... parameterTypes)
     *    方法：
     *      newInstance()方法实例化对象
     */
    @Test
    public void testConstructor() throws Exception {
        Class<Person> personClass = Person.class;//类名.class获取class对象
        //getConstructor(String ...args)方法获取构造方法对象
        Constructor<Person> personConstructor = personClass.getConstructor(String.class, int.class,String.class, int.class);
        System.out.println(personConstructor );
        Person person = personConstructor.newInstance("张三", 19, "北京", 1);//.newInstance()方法创建对象
        System.out.println(person);
        Person person1 = personConstructor.newInstance();//newInstance()方法创建对象
    }

    /**
     * 反射机制获取方法：
     *      getMethods()
     *      getDeclaredMthods()
     *      操作方法
     *      getName()获取方法
     *      invoke()执行方法
     */
    @Test
    public void testMehod() throws Exception {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            //System.out.println(method.getName());
        }
        Method test = personClass.getMethod("test", String.class);//getMethod(String mname,T ...args)//获取方法
        //System.out.println(test.getName());//getName()方法获取方法名称
        test.invoke(new Person(), "张三");//invoke(Object o,args)执行方法

    }
}
