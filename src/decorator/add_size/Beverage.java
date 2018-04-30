package decorator.add_size;


/**
 * 饮料抽象类
 *
 * beverage 饮料
 */
public abstract class Beverage {

    //增加咖啡容量大小枚举(小杯tall  中杯grande  大杯venti)
    public enum Size{TALL,GRANDE,VENTI};
    Size size = Size.TALL;

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * 方法cost必须在子类中实现
     * @return
     */
    public abstract double cost();
}
