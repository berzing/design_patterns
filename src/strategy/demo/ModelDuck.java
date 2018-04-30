package strategy.demo;


/**
 * 鸭子实例--模型鸭
 */
public class ModelDuck extends Duck{

    //模型鸭该开始设定是不会飞  会叫
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("我是模型鸭！！");
    }
}
