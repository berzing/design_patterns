package factory.factory_method;


/**
 * 芝加哥芝士披萨
 */
public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    //重写cut()方法
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
