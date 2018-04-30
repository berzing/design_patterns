package observer.demo.weather;


/**
 * 所有的观察者都必须实现update()方法  进而都需要实现观察者接口
 */
public interface Observer {
    //当气象观测值改变时  主题会把这些状态值当作方法的参数  传递给观察者
    public void update(float temp,float humidity,float pressure);
}
