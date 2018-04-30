package observer.demo.weather;


/**
 * 布告板--目前状况布告板
 */
public class CurrentConditionDisplay implements Observer,DisplayElement {//我们定义所有布告板默认实现DisplayElement接口

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {//构造器需要weatherData对象  用来注册观察者
        this.weatherData = weatherData;
        weatherData.registerObserver(this);//该方法形参类型为Observer  所以类CurrentConditionDisplay需要实现接口Observer
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        //方法display()就只是把最近的温度和湿度显示出来
        System.out.println("current conditions: "+temperature+"F degrees and "+humidity+"% humidity");
    }
}
