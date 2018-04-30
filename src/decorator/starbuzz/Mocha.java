package decorator.starbuzz;


/**
 * 具体装饰者————调料之摩卡(mocha)
 * mocha是一个装饰者  扩展自CondimentDecorator  所以extends了CondimentDecorator
 * 同时CondimentDecorator是扩展自Beverage
 */
public class Mocha extends CondimentDecorator {

    /**
     * 想要mocha能够引用Beverage  做法如下：
     * 1.用一个实例变量记录被装饰者(饮料)
     * 2.让被装饰者(饮料)被记录到实例变量中：将饮料当做构造器参数  再由构造器将此饮料记录到实例变量中
     */
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        //加了调料的饮料我们描述也加上调料名
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        //带摩卡饮料价钱=摩卡钱+饮料钱
        return .20 + beverage.cost();
    }
}
