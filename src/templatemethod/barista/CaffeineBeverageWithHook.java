package templatemethod.barista;


/**
 * 咖啡因饮料(钩子版)
 * 钩子的存在让子类有能力对算法的不同点进行挂钩  要不要挂钩由子类自行决定
 */
public abstract class CaffeineBeverageWithHook {

    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        //加不加饮料看客户需求
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * 这就是一个钩子  子类可以覆盖这个方法  但是不一定需要这么做
     * @return
     */
    boolean customerWantsCondiments(){
        return true;
    }
}
