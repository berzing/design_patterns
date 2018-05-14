package command.simpleremote_traditional;


/**
 * 遥控器
 */
public class SimpleRemoteControl {

    //插槽持有命令  这个命令控制着一个装置
    //slot 卡槽
    Command slot;

    public SimpleRemoteControl() {
    }

    //设置插槽控制的命令  如果客户需要修改遥控器按钮的行为  可以调用这个方法
    public void setCommand(Command command) {
        slot = command;
    }

    //按钮按下时  这个方法就会被调用  使得当前命令关联插槽  并调用它的execute方法
    public void buttonWasPressed() {
        slot.execute();
    }
}
