package enumdemo;

/**
 * 枚举：枚举是一直特殊的类，用于声明一组常量；
 *      * 使用场景：人的性别：“男”,“女”，一周的某一天，当一个常量有几种固定的可能的取值时，可以把他定义为枚举类型。
 *      *在jdk1.5版本之前没有枚举类型，一般使用接口常量来代替
 *
 *     一：枚举的声明：
 *       access-modifiers(访问修饰符：public,private,internal) enum(关键字) enum_name(枚举名称): enum-base(基础类型)
 *       {
 *           enum-body（枚举成员，多个成员使用逗号隔开）
 *       }
 *
 *       *没有显示的声明基础类型的枚举，为int
 *
 *     二：枚举类
 *          java中每一个枚举都继承java.lang.Enum类，定义一个枚举类型时，每一个枚举类型都是Enum的实例，
 *          枚举成员默认被，final ,public, static修饰，所以当使用枚举成员时，直接用枚举名称调用成员
 *          ：枚举类名称.枚举项名称
 *          Enum类常用方法
 *              values()：以数组形式返回枚举类型的所有成员
 *              valueOf()：将普通字符串转换成枚举实例
 *              compareTo()：比较两个枚举成员在定义时的顺序
 *              ordinal()：获取枚举成员的引索位置
 *     三：每个枚举项其实也是该枚举的一个对象
 *
 *    四：枚举类可以有构造器，必须为private类型，
 *         private EnumName (args){
 *
 *         }
 *        枚举项(枚举对象)使用枚举的构造方法：枚举("arg"...)
 *
 *    五：枚举类也可以有抽象方法，枚举项必须重写该方法
 *
 *
 *    六：EnumMap和EnumSet
 *       java.util中添加了两个新类，EnumMap和EnumSet,他可以更高地操作枚举类型。
 *
 *       1):EnumMap类：
 *          一般来说使用HashMap来存储k-v格式的数据，当k为enum类型，就可以考虑使用EnumMap，但是他是一个线程不安全的类
 *          使用方式跟map一样,由于key的值在创建时就知道了，所以使用EnumMap和HashMap相比，EnumMap可以提高效率
 *
 *
 *      2):EnumSet接口：
 *          EnumSet是一个set,然后set中的元素都是Enum类型
 *          EnumSet是一个接口，提供许多的工厂方法便于初始化
 *          初始化方法：
 *          allOf(Class element type)	创建一个包含指定枚举类型中所有枚举成员的 EnumSet 对象
 *          complementOf(EnumSet s)	创建一个与指定 EnumSet 对象 s 相同的枚举类型 EnumSet 对象，并包含所有 s 中未包含的枚举成员
 *          copyOf(EnumSet s)	创建一个与指定 EnumSet 对象 s 相同的枚举类型 EnumSet 对象，并与 s 包含相同的枚举成员
 *          noneOf(<Class elementType)	创建指定枚举类型的空 EnumSet 对象
 *          of(E first,e…rest)	创建包含指定枚举成员的 EnumSet 对象
 *          range(E from ,E to)	创建一个 EnumSet 对象，该对象包含了 from 到 to 之间的所有枚举成员
 *
 *
 */
public class App {
}
