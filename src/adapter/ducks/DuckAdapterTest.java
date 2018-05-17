package adapter.ducks;


/**
 * 鸭子适配器测试
 * 让鸭子看起来像火鸡
 */
public class DuckAdapterTest {

    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        DuckAdapter duckAdapter = new DuckAdapter(mallardDuck);

        System.out.println("鸭子适配器...");
        duckAdapter.gobble();
        duckAdapter.fly();
    }
}
