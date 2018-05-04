package factory.abstract_factory;


/**
 * 蛤蜊披萨
 *
 * "原料工厂"处理了原料差异！！！！！
 * 我们也就不用像以前那样  不但要写"纽约蛤蜊披萨"还要写"芝加哥蛤蜊披萨"
 */
public class ClamPizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();//如果是纽约工厂  就会使用新鲜的蛤蜊  如果是芝加哥工厂  就是冷冻蛤蜊
    }
}
