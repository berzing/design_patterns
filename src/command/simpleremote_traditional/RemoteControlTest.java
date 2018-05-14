package command.simpleremote_traditional;


/**
 * 遥控器测试
 */
public class RemoteControlTest {

    public static void main(String[] args) {
        //遥控器  调用者  会传入一个命令对象  可以用来发出请求
        SimpleRemoteControl remote = new SimpleRemoteControl();
        //创建电灯对象  请求接收者
        Light light = new Light();
        //车库门对象  请求接收者
        GarageDoor garageDoor = new GarageDoor();
        //创建一个命令  将接收者传给他
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);

        //把命令传给调用者
        remote.setCommand(lightOn);
        //模拟按下按钮
        remote.buttonWasPressed();
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }
}
