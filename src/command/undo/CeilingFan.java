package command.undo;


/**
 * 天花板吊扇
 */
public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    //有时候不是非白即黑  吊扇类的速度就有中间状态(抵挡、中档、高档)
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        //速度初始化
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println(location + " ceiling fan is on high");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println(location + " ceiling fan is on medium");
    }

    public void low() {
        speed = LOW;
        System.out.println(location + " ceiling fan is on low");
    }

    public void off() {
        speed = OFF;
        System.out.println(location + " ceiling fan is off");
    }

    /**
     * 获取当前速度
     * @return
     */
    public int getSpeed() {
        return speed;
    }
}
