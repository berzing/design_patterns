package observer.demo.weather;


/**
 * 实现气象站--建立主题接口
 */
public interface Subject {

    //注册方法和删除方法需要一个观察者作为形参
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    //当主题状态改变时  这个方法会被调用  以通知所有的观察者
    public void notifyObservers();
}
