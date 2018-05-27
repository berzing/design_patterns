package iterator.transition_01;


/**
 * 菜单项
 */
public class MenuItem {

    String name;
    String description;
    boolean vegetarian;//素食主义者、素菜
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian(){
        return vegetarian;
    }

    @Override
    public String toString() {
        return name+", "+price+" -- "+description+"\n";
    }
}
