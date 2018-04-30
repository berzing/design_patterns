package decorator.starbuzz;


/**
 * 饮料实现类————综合特调咖啡
 *
 * blend 综合/混合
 * house blend coffee  综合特调咖啡
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    /**
     * 每个具体饮料类都必须实现cost()方法
     * @return
     */
    @Override
    public double cost() {
        return .89;
    }
}
