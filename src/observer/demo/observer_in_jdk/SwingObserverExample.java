package observer.demo.observer_in_jdk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JDK中的观察者模式！！
 * <p>
 * 简单Swing应用   建立一个JFrame  然后放上一个按钮
 */
public class SwingObserverExample {

    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();

        JButton button = new JButton("Should I do it?");
        //制造两个观察者————天使、魔鬼
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER, button);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }


    /**
     * 以下是观察者类定义--天使&魔鬼
     * <p>
     * 当主题(JButton)的状态改变时  在本例中  不是像以前调用update()  而是调用actionPerformed()
     */
    class AngelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("don't do it, you might regret it!");
        }
    }

    class DevilListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("come on, do it!");
        }
    }
}
