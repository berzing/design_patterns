package templatemethod.simplebarista;


/**
 * 咖啡
 */
public class Coffee {

    //咖啡冲泡法
    void prepareRecipe(){
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    //冲泡咖啡
    public void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter");
    }

    //把咖啡倒进杯子
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

    //加糖加奶
    public void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }
}
