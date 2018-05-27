package proxy.gumball;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 *
 * 一：制作远程接口
 * Remote接口是一个"记号"接口  Remote不具有方法  只是用来说明当前接口GumballMachineRemote要用来支持远程调用
 * 注意此处是 extends Remote  (因为接口可以"扩展"接口)
 *
 * 接口GumballMachineRemote声明的所有都要抛出RemoteException异常
 * (如果接口中声明了异常   那么任何实现该接口的类也要处理或抛出该异常)
 * 每次远程调用都必须考虑成"有风险的"!!!!
 *
 * 远程方法的变量和返回值需要是引用类型或原始数据类型或者可序列化(Serializable)类型
 * 因为远程方法的变量必须被打包并通过网络传输  这要靠序列化完成
 * 如果你使用原始类型或引用类型  都不会有问题
 * 但是如果是你自己定义的类    就一定要保证实现了Serializable接口!!!!!!!
 */
public interface GumballMachineRemote extends Remote {
    int getCount() throws RemoteException;
    String getLocation() throws RemoteException;
    State getState() throws RemoteException;
}
