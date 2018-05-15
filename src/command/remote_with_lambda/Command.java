package command.remote_with_lambda;


/**
 * 命令接口
 *
 * 所有遥控器命令都会实现Command接口
 * 遥控器可以通过调用execute()  执行厂商类(Light,CeilingFan)提供的动作
 */
public interface Command {
    void execute();
}
