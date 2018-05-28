package proxy.gumball;


import java.util.Random;

public class HasQuarterState implements State {

    private static final long serialVersionUID = 2L;
    //我们不希望整个糖果机都被序列化并随着State对象一起传送  所以我们使用transient说明一下
    transient GumballMachine gumballMachine;
    Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }


    //投入25分钱、退回25分钱、转动曲柄、发放糖果
    //投入25分钱状态：不能再投另外的25分钱  可以退回已投入的25分钱  可以转动曲柄  不能发放糖果(只有出售状态才可以发放糖果)
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned...");
        int winner = randomWinner.nextInt(10);
        if (winner == 0) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else{
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }


    @Override
    public String toString() {
        return "wait for turn of crank";
    }
}
