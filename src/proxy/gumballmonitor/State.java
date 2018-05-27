package proxy.gumballmonitor;


import java.io.Serializable;

/**
 * 状态接口
 */
public interface State extends Serializable {

    void insertQuarter();  //投入25分钱
    void ejectQuarter();  //退回25分钱
    void turnCrank();  //转动曲柄
    void dispense();  //发放糖果
}
