package singleton.chocolate;


/**
 * 单例巧克力工厂
 */
public class ChocolateBoiler {

    private boolean empty;
    private boolean boiled;
    private static ChocolateBoiler uniqueInstance;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            System.out.println("创建巧克力工厂实例...");
            uniqueInstance = new ChocolateBoiler();
        }
        System.out.println("返回创建的实例...");
        return uniqueInstance;
    }


    //添加原料
    public void fill() {
        //往锅炉添加原料时  锅炉必须是空的
        //添加完成后  改变empty和boiled标志
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    //煮混合物
    public void boil() {
        //煮混合物时锅炉要是满的  且是没有被煮过的
        //煮过之后  改变boiled标志
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    //产品排出
    public void drain() {
        //锅炉排出的时候  必须是满的且是被煮过的
        //排出以后  改变empty标志
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    //是否为空
    public boolean isEmpty() {
        return empty;
    }

    //是否煮沸
    public boolean isBoiled() {
        return boiled;
    }
}
