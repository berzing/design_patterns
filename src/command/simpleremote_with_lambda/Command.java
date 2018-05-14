package command.simpleremote_with_lambda;


/**
 * 命令接口
 *
 * Java8中  如果一个接口只有一个抽象方法  那么这个接口会自动变成"函数式接口"
 * 而只要是函数式接口  我们就可以使用lambda表达式
 *
 * 因此我们没有写具体实现类
 * 我们使用lambda表达式来实现接口：
 * light::on  garageDoor::up  等等
 */
public interface Command {
    public void execute();
}
