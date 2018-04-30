package decorator.starbuzz;


/**
 * 饮料抽象类
 *
 * beverage 饮料
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    /**
     * 方法cost必须在子类中实现
     * @return
     */
    public abstract double cost();
}
