package command.undo;

/**
 * 开灯命令
 */
public class LightOnCommand implements Command {
    Light light;
    int level;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        level = light.getLevel();//开灯之前亮度为0
        light.on();
    }

    public void undo() {
        //调节亮度  execute()打开电灯  所以undo()该做的事情就是恢复到开灯前的0亮度
        light.dim(level);
    }
}
