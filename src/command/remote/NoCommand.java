package command.remote;


/**
 * 空对象
 * 当你不想返回一个有意义的对象  我们就可以返回空对象
 *
 * 这里  遥控器不可能一出厂就设置了有意义的命令对象
 * 所以我们提供 NoCommand 对象作为替代品  当调用它的execute()方法时  空对象什么都不做
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
    }
}
