package decorator.add_size;


/**
 * "装饰者类"————调料抽象类
 * 因为我们想让装饰类CondimentDecorator能够取代饮料类Beverage
 * 所以我们就继承了饮料类Beverage
 *
 * condiment 调料
 */
public abstract class CondimentDecorator extends Beverage {

    /**
     * 所有的调料装饰者类(CondimentDecorator的子类)都必须重新实现getDescription()方法
     *
     * 1.为什么要写成抽象方法？
     * 因为这样其它类继承CondimentDecorator的时候就必须要实现抽象方法getDescription()
     * 2.为什么父类Beverage包含方法getDescription()我们还要重新实现getDescription()方法？
     * 因为不重新实现并设置为抽象方法的话  CondimentDecorator的子类就可以不实现方法getDescription()方法
     * 而我们设计是要让每个调料类都要有属于自己的描述
     * @return
     */
    public abstract String getDescription();
}
