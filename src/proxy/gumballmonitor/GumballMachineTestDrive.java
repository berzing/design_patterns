package proxy.gumballmonitor;

public class GumballMachineTestDrive {

    public static void main(String[] args) {
        int count = 0;
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try{
            count = Integer.parseInt(args[1]);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        GumballMachine gumballMachine = new GumballMachine(args[0],count);

        GumballMonitor monitor = new GumballMonitor(gumballMachine);

        System.out.println(gumballMachine);


        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);


        /**
         * 当前监视器输出不是我想要的
         * 我其实是想"远程监控"糖果机!!!!!!!!!
         */
        monitor.report();
    }
}
