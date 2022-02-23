package threaddemo.basic;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 创建线程方式三：实现Callalbe接口并指定泛型，
 *              重写call()方法
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i <10 ; i++) {
            System.out.println("MyCallable执行了！"+Thread.currentThread().getName()+"----"+new Date().getTime());
        }
        return "MyCallable执行完成！";
    }
}
