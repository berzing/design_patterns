package proxy.virtualproxy;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 图像代理
 *
 * 虚拟代理  一般作为创建开销大的对象的代表
 * 当对象在创建前和创建中时  由虚拟代理来扮演对象的替身
 * 对象创建后  代理就会将请求直接委托给对象
 *
 * 显示CD封面(建立一个应用程序  用来展示CD封面)
 * 我们可以建立一个CD标题菜单  然后从亚马逊网站上取得CD封面
 * 使用Swing  我们可以创建一个Icon接口从网络上加载图像
 * 由于网络的延迟  我们想在图片没有加载成功的时候  显示"正在加载中..."  而不是将整个应用程序挂起
 * =====
 * 要想这样  我们可以使用虚拟代理   虚拟代理可以代理Icon  管理背景的加载  加载未完成时显示"正在加载中..."
 * 一旦加载完成  代理就把显示的职责委托给Icon
 */
public class ImageProxy implements Icon {

    volatile ImageIcon imageIcon;  //此imageIcon是我们希望在加载后显示出来的真正图像
    final URL imageURL;
    Thread retrievalThread;
    boolean retrieving = false;  //恢复(加载完成)

    public ImageProxy(URL url) {  //我们将图像的URL传入构造器中  这是我们希望显示的图像所在的位置
        imageURL = url;
    }

    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;  //图像加载完毕前  返回默认的宽和高  图像加载完毕后  转给imageIcon处理
        }
    }

    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;  //图像加载完毕前  返回默认的宽和高  图像加载完毕后  转给imageIcon处理
        }
    }

    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    //在屏幕上绘制图像
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            //在屏幕上画出一个icon图像(通过委托给imageIcon)
            imageIcon.paintIcon(c, g, x, y);
        } else {
            //如果imageIcon为空  就显示加载中  然后自己创建一个ImageIcon
            g.drawString("Loading CD cover, please wait...", x + 300, y + 190);  //显示"加载中"
            if (!retrieving) {
                retrieving = true;

                //我们不希望挂起整个用户界面  所以用另一个线程取出图像
                retrievalThread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            setImageIcon(new ImageIcon(imageURL, "CD Cover"));
                            c.repaint();  //重绘图像
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                retrievalThread.start();
            }
        }
    }
}
