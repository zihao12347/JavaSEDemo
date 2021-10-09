package functionalprogrammingdemo;

/**
 * 函数式接口：有且只有一个抽象方法，但是可以有其他默认方法，静态方法，私有方法
 *      @FunctionalInterface注解：用于校验接口是一个函数式接口，有且仅有一个抽象方法
 */

@java.lang.FunctionalInterface
public interface FunctionalInterface {

    public abstract void method();
}
