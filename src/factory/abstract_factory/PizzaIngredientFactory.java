package factory.abstract_factory;


/**
 * 原料工厂：负责创建所有的原料
 * 原料工厂中  每个原料都有一个对应的方法创建该原料
 */
public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();//蔬菜
    public Pepperoni createPepperoni();//意式香肠
    public Clams createClam();//蛤蜊
}
