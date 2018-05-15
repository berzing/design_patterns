package command.party;


/**
 * 命令接口(新增undo()方法)
 */
public interface Command {
    void execute();
    void undo();
}
