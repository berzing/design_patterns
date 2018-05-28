package proxy.gumball;


public class SoldState implements State {

    private static final long serialVersionUID = 2L;
    //我们不希望整个糖果机都被序列化并随着State对象一起传送  所以我们使用transient说明一下
    transient GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }


    //投入25分钱、退回25分钱、转动曲柄、发放糖果
    //出售状态：只能发放糖果  其它都不能做
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        try {
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "dispensing a gumball";
    }
}
