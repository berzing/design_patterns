package proxy.gumball;


import java.rmi.RemoteException;


/**
 * 糖果监视器
 * 注意我们依赖的是远程接口GumballMachineRemote  而不是具体的GumballMachine类
 */
public class GumballMonitor {

    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine){
        this.machine = machine;
    }

    public void report(){
        try {
            System.out.println("gumball machine: "+machine.getLocation());
            System.out.println("current inventory: "+machine.getCount()+" gumballs");
            System.out.println("current state: "+machine.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
