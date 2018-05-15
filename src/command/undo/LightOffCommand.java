package command.undo;


/**
 * 关灯命令
 */
public class LightOffCommand implements Command {
    Light light;
    int level;
    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        level = light.getLevel();//关灯前亮度为x
        light.off();
    }

    public void undo() {
        light.dim(level);//撤销操作就是回到关灯前的x亮度
    }
}
