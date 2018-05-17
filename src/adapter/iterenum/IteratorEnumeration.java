package adapter.iterenum;


import java.util.Enumeration;
import java.util.Iterator;

/**
 * 将迭代器适配到枚举
 * 迭代器冒充枚举
 */
public class IteratorEnumeration implements Enumeration<Object> {

    Iterator<?> iterator;

    public IteratorEnumeration(Iterator<?> iterator){
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}
