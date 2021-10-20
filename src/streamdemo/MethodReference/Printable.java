package streamdemo.MethodReference;

/**
 * 定义一个打印函数式的接口
 */
@FunctionalInterface
public interface Printable {
    public abstract void print(String msg);
}
