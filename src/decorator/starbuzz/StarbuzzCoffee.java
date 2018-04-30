package decorator.starbuzz;

public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();  //定一杯espresso  不需要调料  打印出描述与价钱
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();  //制造一个darkRoast对象   调料是双份mocha  一份whip
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        /**
         * Soy,Mocha,Whip都是装饰者  他们都是装饰对象HouseBlend的
         * 装饰者和被装饰者类型相同(都是Beverage的子类)
         *
         * 对应此处  运行beverage3.cost()时
         * 分为8步
         * 1.首先  调用最外层装饰者Whip的cost()
         * 2.Whip 调用Mocha 的cost()
         * 3.Mocha 调用Soy 的cost()
         * 4.Soy 调用HouseBlend的cost()
         * 5.HouseBlend 返回它的价钱
         * 6.Soy 在HouseBlend 的基础上加上自己的价钱  返回新的价钱
         * 7.Mocha 在Soy 返回的结果上加上自己的价钱并返回新的价钱
         * 8.Whip 在Mocha 返回基础上加上自己的价钱并返回新的价钱(咖啡加上调料的总价钱)
         *
         * ========总结
         * 装饰者和被装饰者有相同的超类型(此处是Beverage)
         * 我们可以用一个或多个装饰者包装一个对象
         * ！！！装饰者可以在被装饰者的行为之前/之后  加上自己的行为  以达到特定的目的！！！
         */
        Beverage beverage3 = new HouseBlend();  //制造一个houseBlend  调料是豆浆、摩卡、奶泡
        beverage3 = new Soy(beverage3);//多态  我们可以把mocha所包裹的任何Beverage当成Beverage(Mocha是Beverage的子类)
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
