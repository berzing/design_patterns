package decorator.java_io_decorator;

import java.io.*;

public class InputTest {

    public static void main(String[] args) throws IOException {
        int c;
        try {

            /**
             * 设置FileInputStream  先用BufferedInputStream装饰它  再用我们自己写的LowerCaseInputStream过滤器装饰它
             */
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("D:\\idea\\IdeaProjects\\design_patterns\\src\\decorator\\java_io_decorator\\test.txt")));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            //用流读取字符  一直到文件尾端  每读一个字符  就马上将它显示出来
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
