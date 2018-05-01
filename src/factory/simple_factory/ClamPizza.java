package factory.simple_factory;


/**
 * 蛤蜊比萨
 */
public class ClamPizza extends Pizza {

    public ClamPizza() {
        name = "Clam Pizza";
        dough = "Thin Crust";//薄皮
        sauce = "White garlic sauce";//大蒜酱
        toppings.add("Clams");//蛤蜊
        toppings.add("Grated parmesan cheese");//碎parmesan芝士
    }
}
