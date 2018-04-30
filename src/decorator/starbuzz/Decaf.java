package decorator.starbuzz;


/**
 * 饮料实现类————脱咖啡因咖啡(decaf coffee)
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf Coffee";
    }

    /**
     * 每个具体饮料类都必须实现cost()方法
     * @return
     */
    @Override
    public double cost() {
        return 1.05;
    }
}
