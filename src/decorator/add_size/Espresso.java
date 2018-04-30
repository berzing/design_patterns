package decorator.add_size;


/**
 * 饮料实现类————浓缩咖啡
 * 因为espresso是饮料类的扩展  所以我们需要继承(extends)Beverage类
 *
 * espresso  浓缩咖啡
 */
public class Espresso extends Beverage {

    public Espresso() {
        //具体饮料具体描述(该实例变量继承自Beverage)
        description = "Espresso";
    }

    /**
     * 每个具体饮料类都必须实现cost()方法
     * @return
     */
    @Override
    public double cost() {
        //不管调料价格  单纯浓缩咖啡价格
        return 1.99;
    }
}
