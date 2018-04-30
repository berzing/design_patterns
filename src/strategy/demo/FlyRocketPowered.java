package strategy.demo;


/**
 * 定义新的飞行行为--火箭动力飞行
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("火箭飞行！！");
    }
}
