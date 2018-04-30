package observer.demo.observable;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer,DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.print("forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("improving weather on the way!!!");
        } else if (currentPressure == lastPressure) {
            System.out.println("more of the same!!!");
        } else if (currentPressure < lastPressure) {
            System.out.println("watch out for cooler, rainy weather!!!");
        }
    }
}
