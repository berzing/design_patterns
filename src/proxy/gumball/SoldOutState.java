package proxy.gumball;


public class SoldOutState implements State {

    private static final long serialVersionUID = 2L;
    //我们不希望整个糖果机都被序列化并随着State对象一起传送  所以我们使用transient说明一下
    transient GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }


    //投入25分钱、退回25分钱、转动曲柄、发放糖果
    //售罄状态下  啥都不能做
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public String toString() {
        return "sold out";
    }
}
