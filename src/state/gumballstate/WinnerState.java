package state.gumballstate;

public class WinnerState implements State {

    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

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
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }else{
            gumballMachine.releaseBall();
            System.out.println("you're a winner! you got two gumballs for your quarter");
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            }else{
                System.out.println("oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldState());
            }
        }
    }

    @Override
    public void refill() {
    }

    @Override
    public String toString() {
        return "dispensing two gumballs for your quarter, because you're a winner!";
    }
}
