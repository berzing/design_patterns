package singleton.thread_safe;

public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {
    }

    /**
     * 同步getInstance()会将性能拖垮
     * 但是如果getInstance()的性能对应用程序不是很关键  那就这样吧！
     *
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public String getDescription() {
        return "线程安全单例...";
    }
}
