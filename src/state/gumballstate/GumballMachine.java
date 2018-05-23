package state.gumballstate;


/**
 * 糖果机
 */
public class GumballMachine {

    //所有状态都是在构造器中创建并赋值的
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    //这个实例变量现在持有一个状态对象  而不是一个整数
    State state = soldOutState;
    int count=0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }else{
            state = soldOutState;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    void releaseBall(){
        System.out.println("a gumball comes rolling out the slot...");
        if (count != 0) {
            count-=1;
        }
    }

    int getCount(){
        return count;
    }

    void refill(int count) {
        this.count+=count;
        System.out.println("the gumball machine was just refilled; it's new count is: "+this.count);
        state.refill();
    }

    void setState(State state){
        this.state = state;
    }

    //获取并返回一个状态对象
    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2018");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
