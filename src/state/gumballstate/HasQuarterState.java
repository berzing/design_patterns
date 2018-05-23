package state.gumballstate;


import java.util.Random;


/**
 * 有25分
 */
public class HasQuarterState implements State{

    //增加随机数产生器  产生10%赢的机会
    Random randomWinner = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you can't insert another quarter");
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
        //判断顾客是否赢了  且糖果机不为空  我们让其一次得两粒糖果
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());//赢家状态
        }else{
            gumballMachine.setState(gumballMachine.getSoldState());//售出状态
        }
    }

    @Override
    public void dispense() {
        System.out.println("no gumball dispensed");
    }

    @Override
    public void refill() {
    }

    @Override
    public String toString() {
        return "waiting for turn of crank";
    }
}
