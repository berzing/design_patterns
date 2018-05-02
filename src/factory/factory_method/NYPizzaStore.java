package factory.factory_method;

public class NYPizzaStore extends PizzaStore {

    /**
     * "披萨店"返回一个"披萨"对象
     * 因为PizzaStore中的方法createPizza()是抽象的  所以我们必须实现createPizza()方法
     * @param item
     * @return
     */
    @Override
    Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else if (item.equals("clam")) {
            return new NYStyleClamPizza();
        } else if (item.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else return null;
    }
}
