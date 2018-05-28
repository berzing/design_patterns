package proxy.gumball;

import java.rmi.Naming;


/**
 * 这就是监视器测试程序  CEO会执行此程序
 *
 * 通过调用代理方法  远程调用可以跨过网络  返回字符串、整数和State对象
 * 因为我们使用的是代理  调用的方法会在远程执行
 * 但GumballMonitor根本不用管这些  他只要能监视糖果机就好了
 */
public class GumballMonitorTestDrive {

    public static void main(String[] args) {
        //服务运行位置的主机名或IP地址 + 注册时用的名字
        //以下都是被监视的机器的位置
        String[] location = {
                "rmi://santafe.mightgumball.com/gumballmachine",
                "rmi://boulder.mightgumball.com/gumballmachine",
                "rmi://seattle.mightgumball.com/gumballmachine"
        };

        if (args.length >= 0) {
            location = new String[1];
            location[0] = "rmi://"+args[0]+"/gumballmachine";
        }

        //创建监视器数组
        GumballMonitor[] monitor = new GumballMonitor[location.length];

        for (int i=0;i<location.length;i++) {
            try{
                //客户总是使用远程接口(GumballMachineRemote)作为服务类型(客户不需要知道远程服务的真正类名是什么)
                //lookup()是Naming类的静态方法
                //到RMI registry寻找远程服务
                //lookup()会返回一个远程糖果机的代理(无法定位的话就会抛出异常)!!!!!!!!!!!
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                //一旦有了远程糖果机代理  我们就可以创建一个新的gumballMonitor  并把糖果机代理传递给他
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        for (int i=0;i<monitor.length;i++) {
            monitor[i].report();  //遍历每台监视器  打印报告
        }
    }
}
