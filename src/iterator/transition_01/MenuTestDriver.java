package iterator.transition_01;


/**
 * 测试
 */
public class MenuTestDriver {

    public static void main(String[] args) {
        //创建新菜单
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu,dinerMenu);

        waitress.printMenu();
    }
}
