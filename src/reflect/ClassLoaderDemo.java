package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类加载器:将.class文件加载到内存中，返回class对象
 *      ClassLoader类加载器中的方法：
 *          1.getSystemClassLoader()获取系统类加载器
 *          2.getResourceAsStream()加载某一个资源文件,作为输入字节流返回
 *          3.getParent()返回父类加载器
 *
 *
 *
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws IOException {
        //getSystemClassLoader()方法获取系统类加载器
        ClassLoader systemClassLoader =ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//系统类加载器AppClassLoader加载器
        //getParent()方法获取父类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        //加载某个资源文件，返回一个字节输入流
        InputStream systemResourceAsStream = classLoader.getSystemResourceAsStream("classloadtest.properties");
        Properties properties = new Properties();
        properties.load(systemResourceAsStream);
        System.out.println(properties);

    }
}
