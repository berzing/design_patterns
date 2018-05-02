package factory.factory_method;


/**
 * 我们现在想要披萨制作活动要局限于类PizzaStore  同时又想让这些加盟店自由的制作自己所在区域的披萨风味？
 * 其实我们只需要把方法createPizza()放回到类PizzaStore中  并且将其设置成"抽象方法"
 * 这样  PizzaStore的子类就可以自由的实现自己的createPizza()方法
 *
 * 实例化：
 * "简单工厂"是通过类SimplePizzaFactory中的createPizza()方法来实例化(创建披萨)
 * "工厂方法"变成由一群实现抽象方法的子类来负责实例化(NYPizzaStore,ChicagoPizzaStore)
 *
 * 简单工厂和工厂方法之间的区别？
 * "简单工厂"把全部的事情在一个地方都处理完了  然而"工厂方法"确是创建一个框架  让子类决定要如何实现
 *
 * "依赖倒置原则"？
 * 依赖抽象  不依赖具体类
 * "倒置"体现在哪？
 * 我们之前都是高层组件依赖低层组件(具体实现类)  现在我们发现  低层组件竟然依赖高层的抽象(准确来说  现在PizzaStore与具体的披萨类都依赖Pizza抽象)
 */
public abstract class PizzaStore {

    /**
     * 现在  实例化比萨的责任被移到一个"方法"中  此方法就如同一个"工厂"  这就叫"工厂方法"！！！！！！
     * 将createPizza()设置成抽象方法  这样  PizzaStore的子类就可以自由的实现自己的createPizza()方法
     *
     * @param item
     * @return
     */
    abstract Pizza createPizza(String item);

    /**
     * 由于PizzaStore是抽象类
     * 所以orderPizza()方法并不知道哪个子类将实际上制作披萨(解耦了)
     * 他只知道这个披萨可以被准备、被烘烤、被切片、被装盒
     *
     * @param type
     * @return
     */
    public Pizza orderPizza(String type) {
        //将创建披萨createPizza()方法从工厂对象中移回PizzaStore (简单工厂中该方法是在工厂对象中的)
        Pizza pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
