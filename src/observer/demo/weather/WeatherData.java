package observer.demo.weather;

import java.util.ArrayList;


/**
 * 在类WeatherData中实现主题接口
 */
public class WeatherData implements Subject {

    private ArrayList observers;//使用ArrayList来记录观察者(他是在构造器WeatherData(){}中被建立的)
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);//注册观察者
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);//删除观察者
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer= (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);//每个观察者都实现了update()方法
        }
    }

    public void measurementsChanged() {
        notifyObservers();//当从气象站得到更新观测值时  我们通知观察者
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
