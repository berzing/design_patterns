package observer.demo.observable;

import java.util.Observable;

public class WeatherData extends Observable{

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    //"可观察者(主题)"送出通知
    public void measurementsChanged() {
        /**
         * setChanged()用于标识状态为true  对应的clearChanged()用于标识状态为false
         *
         * setChanged()可以使我们更新观察者时有更多的弹性
         * 通过给了我们一个setChanged()方法  可以让我们控制何时通知观察者
         * 也就是说  之前没有方法setChanged  我要通知观察者我只要调用方法notifyObservers就行
         * 但是现在我要通知观察者之前我们还要调用一下方法setChanged  如果不调用就算主题状态改变了我们也不会去通知观察者
         * 也就是说  setChanged使得通知观察者的时机控制在我们自己手里
         */
        setChanged();
        //当主题状态发生改变时  我们需要"通知"观察者
        //方式1(观察者需要自己pull数据)
        notifyObservers();
        //方式2(push数据给观察者)
        //notifyObservers(Object arg);
        //两种通知方式我们任选其一即可  使用第二种方式我们可以传送任意的数据对象给每个观察者
    }

    public void setMeasurements(float temperature,float humidity,float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


    /**
     * 以下三个方法不是必须的
     * 因为我们通知观察者方式选择的是方式1  观察者需要自己pull数据
     * 所以我们才提供以下方法
     */
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
