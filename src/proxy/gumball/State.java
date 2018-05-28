package proxy.gumball;


import java.io.Serializable;

/**
 * 状态接口
 * State是我们自己写的接口  所以要想实现网络传输  我们就要"继承"Serializable接口(如果是类就实现Serializable接口)
 */
public interface State extends Serializable {

    void insertQuarter();  //投入25分钱
    void ejectQuarter();  //退回25分钱
    void turnCrank();  //转动曲柄
    void dispense();  //发放糖果
}
