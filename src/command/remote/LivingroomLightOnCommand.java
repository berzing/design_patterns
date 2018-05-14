package command.remote;


/**
 * 打开客厅灯命令
 */
public class LivingroomLightOnCommand implements Command{

    Light light;

    public LivingroomLightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
