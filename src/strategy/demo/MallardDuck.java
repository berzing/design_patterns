package strategy.demo;


/**
 * 鸭子实例--绿头鸭
 */
public class MallardDuck extends Duck {

    /**
     * 设定quackBehavior和flyBehavior的实例变量
     * 绿头鸭使用Quack类处理呱呱叫  所以当调用超类Duck中的performQuack()时  就会把责任委托给Quack对象进行真正的呱呱叫
     *
     * MallardDuck因为继承的Duck  所以他具有实例变量quackBehavior和flyBehavior
     */
    public MallardDuck() {
        quackBehavior = new Quack();//多态  关键代码！！！
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("我是绿头鸭！！");
    }
}
