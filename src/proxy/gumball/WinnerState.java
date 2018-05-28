package proxy.gumball;



/**
 * 赢家状态
 */
public class WinnerState implements State {

    private static final long serialVersionUID = 2L;
    //我们不希望整个糖果机都被序列化并随着State对象一起传送  所以我们使用transient说明一下
    transient GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    //投入25分钱、退回25分钱、转动曲柄、发放糖果
    //赢家状态：因为处于赢家状态  其它什么都不能做   但糖果会发放两粒
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a Gumball");
    }

    public void ejectQuarter() {
        System.out.println("Please wait, we're already giving you a Gumball");
    }

    public void turnCrank() {
        System.out.println("Turning again doesn't get you another gumball!");
    }

    @Override
    public void dispense() {
        System.out.println("you're a winner! you get two gumballs for your quarter");
        try {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() == 0) {
                gumballMachine.setState(gumballMachine.getSoldOutState());
            } else {
                gumballMachine.releaseBall();
                if (gumballMachine.getCount() > 0) {
                    gumballMachine.setState(gumballMachine.getNoQuarterState());
                } else {
                    System.out.println("oops, out of gumballs!");
                    gumballMachine.setState(gumballMachine.getSoldOutState());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "dispensing two gumballs for your quarter, because you're a winner!";
    }
}
