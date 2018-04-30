package observer.demo.observable;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        /**
         * 注意  输出结果是与我们类定义顺序相反  为什么
         * 因为java.util中类Observable中的notifyObservers(Object arg)方法在输出的时候是按照下标从大到小输出的！！
         */
        weatherData.setMeasurements(80, 65, 30.4f);
//        weatherData.setMeasurements(82, 70, 29.2f);
//        weatherData.setMeasurements(78, 90, 29.2f);

        /**
         * java.util.Observable黑暗面！！！
         *
         * 缺陷：
         * 可观察者Observable是一个"类"而不是一个"接口"  并且他也没有实现一个接口
         * 这是一个很大的设计缺陷
         * 还有就是他将关键方法setChanged()保护(protected)起来了
         * 这样一来  我想使用该方法前必须要事先继承Observable
         * 其实应该设为public的  这样我们可以创建Observable实例就可以使用setChanged()  而不需要继承Observable
         * 这违反了我们的设计原则"多用组合  少用继承"
         */
    }
}
