package functionalprogrammingdemo.logdemo;
@FunctionalInterface
public interface MessageBuilder {
    //定义一个拼接日志消息的抽象方法，返回被拼接的消息
    public abstract String builderMessage();
}
