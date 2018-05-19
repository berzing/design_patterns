package templatemethod.simplebarista;


/**
 * 茶
 * 方法boilWater()  pourInCup()  和咖啡中的方法完全一样!!!!
 */
public class Tea {

    //冲泡法
    void prepareRecipe(){
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    public void addLemon() {
        System.out.println("Adding Lemon");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
