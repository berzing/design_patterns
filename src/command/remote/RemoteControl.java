package command.remote;


/**
 * 遥控器
 *
 * 管理一组命令对象  每个按钮都有一个命令对象
 * 每当按下按钮  就调用相应的xxButtonWasPushed()方法  因而execute()方法会被调用
 */
public class RemoteControl {


    //遥控器需要控制7个开/关命令  使用相应数组记录命令
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        //实例化 开/关数组
        onCommands = new Command[7];
        offCommands = new Command[7];

        //使用"空对象"初始化 开/关数组
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    //插槽位置、开的命令、关的命令
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }


    //按下开/关按钮  硬件负责调用对应的方法  也就是onButtonWasPushed()与offButtonWasPushed()
    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }


    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n----- Remote Control -----\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();
    }
}
