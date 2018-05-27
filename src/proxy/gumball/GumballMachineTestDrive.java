package proxy.gumball;

import java.rmi.Naming;


/**
 * 二：制作远程实现
 * (续)GumballMachine
 * 4. 用 RMI Registry 注册远程服务 GumballMachine(远程服务要想被远程客户调用  需要在RMI Registry中注册一下)
 *    (注册时注意保证RMI Registry是正在运行状态  否则注册会失败!!!!!!!)
 *
 * 当注册这个实现对象时  RMI系统其实注册的是stub  因为这是客户真正需要的
 * 注册服务使用了java.rmi.Naming类的静态方法rebind()方法
 */
public class GumballMachineTestDrive {

    public static void main(String[] args) {
        GumballMachineRemote gumballMachine = null;
        int count;

        if (args.length < 2) {
            System.out.println("gumballMachine <name> <inventory>");
            System.exit(1);
        }

        try{
            count = Integer.parseInt(args[1]);
            //实例化远程服务
            gumballMachine = new GumballMachine(args[0],count);
            //服务要起名字  这样客户在注册表好找些
            //注册服务
            //当你绑定(bind)服务对象时  RMJ会把服务换成stub  然后把stub放到registry中
            Naming.rebind("//"+args[0]+"/gumballmachine", gumballMachine);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
