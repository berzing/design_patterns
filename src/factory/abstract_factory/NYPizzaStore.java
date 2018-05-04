package factory.abstract_factory;


/**
 * 纽约披萨店
 */
public class NYPizzaStore extends PizzaStore {


    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        //纽约店会用到纽约披萨原料工厂(纽约店的所有需要的原料都由该原料工厂生产)
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {
            //把工厂ingredientFactory传递给每一个披萨  以便披萨能从工厂中取得原料
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        return pizza;
    }
}
