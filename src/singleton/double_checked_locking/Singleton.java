package singleton.double_checked_locking;


/**
 * 使用"双重检查锁"在getInstance()中减少使用同步
 * <p>
 * 我们首先检查实例是否已经创建  如果没有创建  "才"进行同步(synchronized)
 * 这样一来  只有第一次会同步  这正是我们想要的
 * <p>
 * 关键字volatile
 * 一般用在多线程中  同步变量
 * 线程为了提高效率  将某成员变量(A)复制了一份(B)
 * 线程中对A的访问其实访问的是B  只在某些动作时才进行A和B的同步  因此存在A和B不一致的情况
 * volatile就是用来避免这种情况的
 * volatile告诉jvm  他所修饰的变量不保留拷贝  直接访问的内存中的(也就是上面说的A)
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
