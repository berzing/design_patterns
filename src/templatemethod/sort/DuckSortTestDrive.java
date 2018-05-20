package templatemethod.sort;


import java.util.Arrays;

/**
 * 鸭子排序测试
 */
public class DuckSortTestDrive {

    public static void display(Duck[] ducks){
        for (Duck d : ducks) {
            System.out.println(d);
        }
    }

    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("tom",2),
                new Duck("jerry",1),
                new Duck("hunter",9),
                new Duck("peter",5),
                new Duck("alice",3)
        };

        System.out.println("排序前：");
        display(ducks);
        //调用Array类的sort()模板方法
        Arrays.sort(ducks);
        System.out.println("排序后：");
        display(ducks);
    }
}
