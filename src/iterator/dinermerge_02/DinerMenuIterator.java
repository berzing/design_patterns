package iterator.dinermerge_02;


import java.util.Iterator;

/**
 * 餐厅菜单迭代器
 */
public class DinerMenuIterator implements Iterator<MenuItem> {

    MenuItem[] list;
    int position = 0;

    public DinerMenuIterator(MenuItem[] list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        //注意  数组元素下标是从0到list.length-1(position的下标是从0到list.length)  position永远比当前元素下标大1(永远指向下一个)
        //所以  position=list.length时  是return false
        //所以  下一个元素是list[position]  当前元素是list[position-1]
        if (position >= list.length || list[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem=list[position];
        position+=1;
        return menuItem;
    }

    public void remove(){
        if (position <= 0) {
            throw new IllegalStateException("you can't remove an item until you've done at least one next()");
        }
        if (list[position - 1] != null) {
            for (int i=position-1;i<(list.length-1);i++){
                //因为使用的固定长数组  所以在remove()被调用时  我们将后面的所有元素往前移动一个位置
                list[i]=list[i+1];
            }
            list[list.length-1]=null;
        }
    }
}
