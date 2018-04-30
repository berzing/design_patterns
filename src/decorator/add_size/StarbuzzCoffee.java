package decorator.add_size;



public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage2 = new Espresso();  //制造一个大杯浓缩对象  调料是豆浆(浓缩咖啡价格为1.99,大杯豆浆调料价格是0.20)
        beverage2.setSize(Beverage.Size.VENTI);
        beverage2 = new Soy(beverage2);//Soy是装饰者
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
