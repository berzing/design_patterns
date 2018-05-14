package command.remote;


/**
 * 实现打开风扇的命令
 */
public class CeilingFanOffCommand implements Command{

    CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }
}
