package templatemethod.frame;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame是最基本的Swing容器  继承了一个paint()方法
 * 默认状态下  paint()是不做事情的  他是一个"钩子"
 */
public class MyFrame extends JFrame {

    private static final long serialVersionUID = 2L;

    public MyFrame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300,300);
        this.setVisible(true);
    }

    //钩子
    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "hello design patterns";
        graphics.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Head First Design Patterns");
    }
}