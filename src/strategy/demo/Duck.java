package strategy.demo;

public abstract class Duck {

    //为行为接口类型FlyBehavior与QuackBehavior声明两个引用变量  所有鸭子子类都会继承他们
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){}

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("所有鸭子都会游泳哦！！");
    }


    //添加改变鸭子行为的两个新方法(这样我们可以随时改变鸭子的行为)
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}
