package factory.simple_factory;


/**
 * 芝士比萨
 */
public class CheesePizza extends Pizza {

    public CheesePizza() {
        name = "Cheese Pizza";
        dough = "Regular Crust";//普通披萨皮
        sauce = "Marinara Pizza Sauce";//番茄酱
        toppings.add("Fresh Mozzarella");//新鲜意大利干酪
        toppings.add("Parmesan");//意大利硬奶酪
    }
}
