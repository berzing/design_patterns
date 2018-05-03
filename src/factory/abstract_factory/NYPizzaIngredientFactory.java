package factory.abstract_factory;


/**
 * 纽约原料工厂(需要实现接口"披萨原料工厂")
 * 对于原料家族的每一种原料  我们都提供了纽约版本
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    /**
     * 对于蔬菜  我们返回了一个蔬菜数组
     * @return
     */
    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }

    /**
     * 切片意式香肠(纽约和芝加哥都会用到它)
     * @return
     */
    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    /**
     * 纽约特有的新鲜蛤蜊
     * @return
     */
    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
