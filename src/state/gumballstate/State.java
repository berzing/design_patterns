package state.gumballstate;


/**
 * 状态接口
 */
public interface State {

    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
    void refill();
}
