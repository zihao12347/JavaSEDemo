package reflect.task;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 框架类：
 *案例：
 *  需求:写一个框架类，不能改变该类的任意代码的前提下，可以创建任意类的对象，并执行其中的方法
 *  实现：
 *      1.配置文件
 *      2.反射
 *  步骤：
 *      1.将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 *      2.在程序在加载读取配置文件
 *      3.实现反射技术加载类文件进内存
 *      4.创建对象
 *      5.执行方法
 *
 */
public class ReflectTest {
    @Test
    public void testOne() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(new File("D:\\develop\\javasedemo\\src\\reflect\\task\\test.properties")));//读取配置文件中的key-value
        Class<ReflectTest> testClass = ReflectTest.class;//获取class类对象


    }
}
