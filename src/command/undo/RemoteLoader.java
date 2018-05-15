package command.undo;


/**
 * 测试类
 */
public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        Light livingRoomLight = new Light("Living Room");

        LightOnCommand livingRoomLightOn =
                new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff =
                new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        //开灯按钮
        remoteControl.onButtonWasPushed(0);
        //关灯按钮
        remoteControl.offButtonWasPushed(0);
        //打印遥控信息
        System.out.println(remoteControl);
        //撤销按钮
        remoteControl.undoButtonWasPushed();
        //关灯按钮
        remoteControl.offButtonWasPushed(0);
        //开灯按钮
        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        //撤销按钮
        remoteControl.undoButtonWasPushed();


        //===============吊扇测试
        CeilingFan ceilingFan = new CeilingFan("Living Room");

        //中档
        CeilingFanMediumCommand ceilingFanMedium =
                new CeilingFanMediumCommand(ceilingFan);
        //高档
        CeilingFanHighCommand ceilingFanHigh =
                new CeilingFanHighCommand(ceilingFan);
        //关闭
        CeilingFanOffCommand ceilingFanOff =
                new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);

        remoteControl.onButtonWasPushed(0);//开启时是中速
        remoteControl.offButtonWasPushed(0);//关闭
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();//撤销  会回到中速状态

        remoteControl.onButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }
}
