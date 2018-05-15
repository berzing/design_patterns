package command.party;


/**
 * 宏命令
 * 批量执行多个命令的命令
 */
public class MacroCommand implements Command {

    Command[] commands;

    public MacroCommand(Command[] commands) {
        //宏命令中  使用数组存储多个命令
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            //当宏命令被遥控器执行时  就会依次执行数组中的每个命令
            commands[i].execute();
        }
    }

    @Override
    public void undo() {
        for (int i=commands.length-1;i>=0;i--) {
            commands[i].undo();
        }
    }
}
