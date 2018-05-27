package iterator.transition_01;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * 煎饼屋菜单迭代器
 */
public class PancakeHouseMenuIterator implements Iterator {

    ArrayList<MenuItem> items;
    int position = 0;

    public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = items.get(position);
        position += 1;
        return menuItem;
    }
}
