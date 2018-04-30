package decorator.add_size;


/**
 * 装饰者————调料之豆浆
 */
public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        if (beverage.getSize() == Size.TALL) {
            return 0.10 + beverage.cost();
        }
        else if (beverage.getSize() == Size.GRANDE) {
            return 0.15 + beverage.cost();
        }
        else if (beverage.getSize() == Size.VENTI) {
            return 0.20 + beverage.cost();
        }
        return 0.0;
    }
}
