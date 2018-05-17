package adapter.ducks;


/**
 * 火鸡适配器--让火鸡看起来像鸭子
 *
 * 实现的是鸭子接口
 * 传的是火鸡对象
 */
public class TurkeyAdapter implements Duck {

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        //鸭子叫方法里面调用的是火鸡叫的方法
        turkey.gobble();
    }

    @Override
    public void fly() {
        //火鸡飞的不远  我们就飞5次
        for (int i=0;i<5;i++) {
            turkey.fly();
        }
    }
}
