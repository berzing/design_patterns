package decorator.starbuzz;


/**
 * 饮料实现类————深焙咖啡(dark roast coffee)
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    /**
     * 每个具体饮料类都必须实现cost()方法
     * @return
     */
    @Override
    public double cost() {
        return .99;
    }
}
