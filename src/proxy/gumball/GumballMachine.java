package proxy.gumball;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * 糖果机
 * 做实际工作的类  这就是客户真正想要调用方法的对象
 *
 * 二：制作远程实现
 * 1. 实现远程接口
 * 你的服务(GumballMachine)必须实现远程接口  也就是客户将要调用的方法的接口(GumballMachineRemote)
 * 2. 扩展UnicastRemoteObject
 * 为了成为远程服务对象  你的对象需要某些"远程的"功能
 * 最简单的办法就是扩展java.rmi.server.UnicastRemoteObject 让超类帮我们做这些工作
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    private static final long serialVersionUID = 2L;
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;
    String location;


    /**
     * 3. 因为我们的超类UnicastRemoteObject的构造器会抛出RemoteException异常
     * 所以我们的"远程实现"GumballMachine的构造器也需要抛出一个RemoteException异常
     *
     * @param location
     * @param numberGumballs
     * @throws RemoteException
     */
    public GumballMachine(String location,int numberGumballs) throws RemoteException {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
        this.location = location;
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


    void setState(State state){
        this.state = state;
    }

    void releaseBall(){
        System.out.println("a gumball comes rolling out the slot...");
        if (count != 0) {
            count -= 1;
        }
    }

    public void refill(int count){
        this.count = count;
        state = noQuarterState;
    }


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

    @Override
    public State getState() {
        return state;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public int getCount() {
        return count;
    }


    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nmight gumball, inc.");
        result.append("\njava-enabled standing gumball model #2018");
        result.append("\ninventory: "+count+" gumball");
        if (count > 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("machine is "+state+"\n");
        return result.toString();
    }
}
