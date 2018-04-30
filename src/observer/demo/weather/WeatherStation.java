package observer.demo.weather;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        //目前状况
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        //统计
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        //预测
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        //酷热指数
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 68, 33.4f);
        weatherData.setMeasurements(79, 50, 22.4f);
    }
}
