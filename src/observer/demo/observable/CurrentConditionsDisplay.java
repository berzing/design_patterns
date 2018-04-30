package observer.demo.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 目前状况布告板
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;

    /**
     * 现在构造器需要"可观察者(主题)"Observable当形参
     * 因为我们需要将CurrentConditionsDisplay对象注册为观察者
     *
     * @param observable
     */
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    /**
     * Observable是主题本身  好让观察者知道是哪个主题通知他的
     * Object是"通知观察者的方式2中的方法notifyObservers(Object arg)"的传入参数  如果没有就传null
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {//确定观察者属于WeatherData类型
            WeatherData weatherData = (WeatherData) o;
            //利用getter方法获取数据
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            //展示数据
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
