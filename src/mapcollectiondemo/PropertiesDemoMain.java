package mapcollectiondemo;

import list_setcollectiondemo.Person;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 *  Properties：map集合体系中的一个集合类（继承了hashTable集合）
 *      *properties是Map集合体系（继承hashtable集合）中的一个集合类
 *      *properties可以保存到流中或者从流中加载
 *   Properties集合的方法：
 *      1.setProperty(String k,String v)设置集合的键值
 *      2.getProperty(String k)根据键来搜索v值
 *      3.stringPropertyNames()返回集合中的键集合
 *   properties操作流：
 *      读取：
 *          1.load(inputStream s)读取输入字节流
 *          2.load(Read r)读取字符输入流
 *      写入：
 *          store(outputStream o,String comments)写入到字节输出流中
 *          store(Writer w,String comments)写入到字符输出流中
 *
 *
 */
public class PropertiesDemoMain {
    /**
     * Properties作为map集合类使用
      */
    @Test
    public void testPropertisasCol(){
        //创建properties集合类
        Properties properties = new Properties();//properties不能指定泛型,默认为object
        properties.put("itheima", "张三");//put()添加元素
        properties.put("itheima", "李四");
        properties.put("itheima", "王五");
        //遍历元素
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();//获取键值对对象集合
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry);
        }
    }

    /**
     * 使用Properties集合中的方法
     *          1.setProperty(k,v)设置集合的键值,底层调用的是hashTable的put()方法
     *          2.getProperty(k)通过集合中的k键获取对应的v值,底层调用的是hashTable的get()方法
     *          3.stringPropertyName()返回集合中的键集合,底层调用hashTable集合的keySet()方法，返回key集合类型为set集合
     */
    @Test
    public void testPropertiesMehthod(){
        //创建properties集合
        Properties properties = new Properties();
        properties.setProperty("name", "张三");//setProperty(k,v)设置k和v
        properties.put("age", "19");
        properties.put("address", "北京");
        //setProperty()设置集合中的键值
        properties.setProperty("birthday", "2000/06/22");
        //getProperty(k)通过k键获取v值
        String address = properties.getProperty("address");
        //System.out.println(address);
        //stringPropertyNames()返回集合中的key集合
        Set<String> set = properties.stringPropertyNames();
        for (String s : set) {
            //System.out.println(s);
        }
    }

    /**
     * properties对象操作流：写入
     *      store(OutputStream o)
     *      store(Writer w)
     */
    @Test
    public void testStore() throws IOException {
          //创建perperties对象
        Properties properties = new Properties();
        properties.setProperty("name", "张三");
        properties.setProperty("age", "19");
        FileWriter writer = new FileWriter(new File("D:\\develop\\javasedemo\\src\\mapcollectiondemo\\pro.properties"));
        properties.store(writer, null);
        writer.close();
    }

    /**
     * properties对象操作流：读取
     *      1.load(InputStream i)
     *      2.load(Reader r)
     */
    @Test
    public void testread() throws IOException {
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(new File("D:\\develop\\javasedemo\\src\\mapcollectiondemo\\pro.properties"));
        properties.load(fileReader);
        System.out.println(properties);
        fileReader.close();

    }

}
