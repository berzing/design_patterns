package iterator.transition_1;


import java.util.Iterator;

/**
 * 餐厅菜单迭代器
 */
public class DinerMenuIterator implements Iterator {

    MenuItem[] items;
    int position = 0;//记录当前数组遍历的位置

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }


    /**
     * 因为使用的是固定长度的数组  所以我们不但要检查是否超出了数组长度  也要检查下一项是不是null  如果是null就表示没有其他项了
     * @return
     */
    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position += 1;
        return menuItem;
    }
}
