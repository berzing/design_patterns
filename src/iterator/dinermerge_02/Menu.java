package iterator.dinermerge_02;


import java.util.Iterator;

/**
 * 菜单接口
 */
public interface Menu {
    public Iterator<MenuItem> createIterator();
}
