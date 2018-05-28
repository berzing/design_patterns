package proxy.gumball;


public class NoQuarterState implements State {

    private static final long serialVersionUID = 2L;
    //我们不希望整个糖果机都被序列化并随着State对象一起传送  所以我们使用transient说明一下
    transient GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    //投入25分钱、退回25分钱、转动曲柄、发放糖果
    //未投钱状态：可以投入25分钱   不能退回25分钱  转动曲柄无效  不能发放糖果
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }

    public void dispense() {
        System.out.println("You need to pay first");
    }


    @Override
    public String toString() {
        return "waiting for quarter";
    }
}
