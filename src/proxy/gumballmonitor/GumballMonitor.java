package proxy.gumballmonitor;


/**
 * 糖果监视器
 */
public class GumballMonitor {

    GumballMachine machine;

    public GumballMonitor(GumballMachine machine){
        this.machine = machine;
    }


    //新方法  将会打印糖果机位置、库存、机器状态
    public void report(){
        System.out.println("gumball machine: "+machine.getLocation());
        System.out.println("current inventory: "+machine.getCount()+" gumballs");
        System.out.println("current state: "+machine.getState());
    }
}
