package singleton.classic;


/**
 * 单例模式经典实现
 */
public class Singleton {

    private static Singleton uniqueInstance;

    //把构造器声明为私有的  该构造器只能在类Singleton内部调用
    private Singleton() {
    }

    //开放一个公有方法供外界调用
    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            //注意如果不需要这个实例  他就永远不会产生  这就是"懒加载"
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    //其它有用的方法
    public String getDescription() {
        return "单例模式经典实现！";
    }
}
