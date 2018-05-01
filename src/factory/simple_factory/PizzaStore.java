package factory.simple_factory;

public class PizzaStore {

    SimplePizzaFactory factory;

    //需要一个工厂作为参数
    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    /**
     * 该方法是工厂SimplePizzaFactory的客户
     * 现在我们不需要使用new操作符来创建披萨对象  我们使用的工厂中的createPizza()来创建披萨对象
     *
     * @param type
     * @return
     */
    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
