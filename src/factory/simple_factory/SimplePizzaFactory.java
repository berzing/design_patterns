package factory.simple_factory;

/**
 * 将创建对象的代码独立成工厂  任何对象想要创建披萨对象  找工厂就好
 * 方法orderPizza()就变成当前工厂对象的客户
 *
 * SimplePizzaFactory就只做一件事：帮客户创建披萨
 *
 * 把创建比萨的代码包装进一个类  当以后实现改变时  只需要修改这个类即可
 */
public class SimplePizzaFactory {

    //根据披萨的类型  我们实例化类型对应的具体类
    public static Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
