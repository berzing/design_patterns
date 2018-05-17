package adapter.iterenum;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

/**
 * 枚举适配器测试
 * 用枚举冒充迭代器
 */
public class EnumerationIteratorTest {

    public static void main(String[] args) {
        Vector vector = new Vector(Arrays.asList(args));//args参数你自己输入
        Iterator<?> iterator = new EnumerationIterator(vector.elements());//枚举冒充迭代器
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
