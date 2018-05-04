package factory.abstract_factory;


/**
 * 芝士披萨
 * <p>
 * 我们用"工厂方法"实现"芝士披萨"代码  需要写两个类  NYCheesePizza与ChicagoCheesePizza
 * 但是比较一下  我们发现  他们之间的差异仅在于原料的差异(大的层面上都是面团+酱料+芝士)
 * <p>
 * 因此  我们并不需要设计两个类！！！
 * 我们可以使用"原料工厂"来处理原料上的差异！！！！！！
 */
public class CheesePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;


    /**
     * 要制作披萨  就需要工厂提供原料
     * 所以每个披萨类都需要从构造器参数中得到一个"原料工厂"
     * 并把这个工厂存储到一个实例变量中
     *
     * @param ingredientFactory
     */
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }


    /**
     * prepare()一步一步的创建芝士披萨
     * 每当需要原料时  就跟工厂要
     */
    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
