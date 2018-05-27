package proxy.gumball;


import java.rmi.RemoteException;


/**
 * 糖果监视器
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
