package factory.simple_factory;

import java.util.ArrayList;

public abstract class Pizza {

    String name;
    String dough;//面皮
    String sauce;//酱料
    ArrayList<String> toppings = new ArrayList<String>();//佐料

    public String getName() {
        return name;
    }

    //准备
    public void prepare() {
        System.out.println("Preparing " + name);
    }

    //烘烤
    public void bake() {
        System.out.println("Baking " + name);
    }

    //切片
    public void cut() {
        System.out.println("Cutting " + name);
    }

    //装盒
    public void box() {
        System.out.println("Boxing " + name);
    }

    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("----" + name + "----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        for (String topping : toppings) {
            display.append(topping + "\n");
        }
        return display.toString();
    }
}
