package iterator.dinermerge_02;


import java.util.HashMap;
import java.util.Iterator;

/**
 * 咖啡厅菜单
 */
public class CafeMenu implements Menu {

    HashMap menuItems = new HashMap();

    public CafeMenu(){
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29);
    }

    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        //此处我们不是取得整个HashTable迭代器  而是取得值的部分的迭代器
        return menuItems.values().iterator();
    }
}
