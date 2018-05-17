package adapter.iterenum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * 迭代器冒充枚举类测试
 */
public class IteratorEnumerationTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(args));//参数args自己输入
        Enumeration<?> enumeration = new IteratorEnumeration(list.iterator());
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
