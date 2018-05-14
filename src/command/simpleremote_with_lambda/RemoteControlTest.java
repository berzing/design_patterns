package command.simpleremote_with_lambda;


/**
 * 模拟的命令模式的客户
 */
public class RemoteControlTest {

    public static void main(String[] args) {

        //遥控器就是调用者  会传入一个命令对象  可以用来发出请求
        SimpleRemoteControl remote = new SimpleRemoteControl();
        //创建电灯对象  此对象是请求的接收者
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();


        //实现接口有3中方法：直接写一个实现类、匿名内部类、lambda表达式
        //如果一个接口是"函数式接口"  那么使用lambda表达式实现接口无疑是最简洁的！！！！！


        /**
         * 0. 使用lambda表达式实现接口!!!!!!!
         * 方法setCommand()参数类型是Command  而lambda表达式 light::on 类型是Command
         *
         * lambda表达式一般形式为：
         * () -> {};
         * :: 是lambda表达式的简化版  此处 light::on 是使用的实例light引用实例方法on
         *
         * light::on 实现了接口Command的execute()方法   light::on的类型为Command
         * 方法 execute() 里面就一行代码：调用接收对象(Light)的on()方法
         */
        remote.setCommand(light::on);//使用"接收者(电灯)"实现命令  并将命令传给调用者
        remote.buttonWasPressed();//模拟按下按钮


        /*
        // 1. 匿名内部类实现Command接口
        Command command = new Command() {
            @Override
            public void execute() {
                new Light().on();
            }
        };
        remote.setCommand(command);
        remote.buttonWasPressed();
        */


        /*
        // 2. 新建一个类作为接口Command的实现类
        实现类LightOnCommand.java实现如下：
        public class LightOnCommand implements Command {
            Light light;
            public LightOnCommand(Light light) {
                this.light = light;
            }
            @Override
            public void execute() {
                light.on();
            }
        }

        客户端代码如下：
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        remote.setCommand(lightOnCommand);
        remote.buttonWasPressed();
         */


        remote.buttonWasPressed();
        remote.setCommand(garageDoor::up);
        remote.buttonWasPressed();
        remote.setCommand(garageDoor::lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageDoor::lightOff);
        remote.buttonWasPressed();
    }
}
