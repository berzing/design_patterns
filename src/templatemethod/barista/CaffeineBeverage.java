package templatemethod.barista;


/**
 * 咖啡因饮料
 * 当前类专注于算法本身  而由子类提供完整的实现
 */
public abstract class CaffeineBeverage {

    /**
     * 冲泡法
     * 该方法被声明为final  因为我们希望子类覆盖这个方法
     */
    final void prepareRecipe(){
        boilWater();//把水煮沸
        brew();//用热水泡咖啡或茶
        pourInCup();//把饮料倒进杯子
        addCondiments();//加调料
    }

    /**
     * 冲泡方法、调料添加
     * 咖啡、茶自己实现自己的冲泡方法和调料添加
     */
    abstract void brew();
    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }

    void pourInCup(){
        System.out.println("Pouring into cup");
    }
}
