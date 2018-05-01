package factory.simple_factory;


/**
 * 意式香肠比萨
 */
public class PepperoniPizza extends Pizza {

    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Crust";//普通皮
        sauce = "Marinara Sauce";//番茄酱
        toppings.add("Sliced Pepperoni");
        toppings.add("Sliced Onion");
        toppings.add("Grated parmesan cheese");
    }
}
