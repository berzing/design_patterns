package adapter.ducks;


/**
 * 火鸡适配器测试
 * 让火鸡看起来像鸭子
 */
public class TurkeyAdapterTest {

    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        WildTurkey wildTurkey = new WildTurkey();

        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);

        System.out.println("鸭子...");
        test(mallardDuck);
        System.out.println("火鸡...");
        wildTurkey.gobble();
        wildTurkey.fly();
        System.out.println("火鸡适配器(让火鸡看起来像鸭子  实际上还是像火鸡)...");
        test(turkeyAdapter);
    }

    public static void test(Duck duck){
        duck.quack();
        duck.fly();
    }
}
