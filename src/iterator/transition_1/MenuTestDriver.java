package iterator.transition_1;


/**
 * 测试
 */
public class MenuTestDriver {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu,dinerMenu);

        waitress.printMenu();
    }
}
