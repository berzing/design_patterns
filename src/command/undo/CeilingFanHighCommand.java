package command.undo;


/**
 * 吊扇 高档风命令
 */
public class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;
    //增加局部状态  以记录吊扇之前的速度
    int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        //改变吊扇速度之前  需将之前的状态记录起来  在需要"撤销"时可以拿来使用
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        //将吊扇速度设置回之前的值
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
