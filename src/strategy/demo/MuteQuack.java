package strategy.demo;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("我叫不了！！");
    }
}
