package singleton.eagerly;

/**
 * 使用"急切"创建实例  而不用"懒加载"的做法
 * 我们依赖JVM在加载这个类时马上创建此唯一的单件实例
 * JVM保证在任何线程访问uniqueInstance静态变量之前  一定先创建此实例
 */
public class Singleton {

    //在静态初始化器中创建单件  这段代码保证了线程安全
    //类初始化顺序：静态变量>静态初始化块>变量>初始化块>构造器
    private static Singleton uniqueInstance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return uniqueInstance;
    }

    public String getDescription() {
        return "在静态初始化器中创建单例...";
    }
}
