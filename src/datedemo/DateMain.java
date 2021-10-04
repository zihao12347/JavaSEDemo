package datedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date日期类对象:
 *  SimpleDateFormat日期格式化类：
 *          format(Date)方法:将date对象转化成一个字符串
 *          parse(String)方法：将字符串解析成一个date对象
 */
public class DateMain {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);//Sun Oct 03 22:05:26 CST 2021
        SimpleDateFormat Format = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
        String formatdate = Format.format(date);//将date对象转化成字符串
        System.out.println(formatdate);
        Date parsedate = Format.parse(formatdate);//将字符串解析成date对象
        System.out.println(parsedate);
    }
}
