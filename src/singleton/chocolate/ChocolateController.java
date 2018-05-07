package singleton.chocolate;


/**
 * 巧克力工厂控制器
 */
public class ChocolateController {

    public static void main(String[] args) {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();

        boiler.fill();
        boiler.boil();
        boiler.drain();

        //本次创建没有输出  "创建巧克力工厂实例..."  说明返回的是已经存在了的实例！！！！
        ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
    }
}
