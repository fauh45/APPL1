package Soal1;

import java.util.ArrayList;
import java.util.List;

public class WeatherTracker {
    private String currentConditions;
    private List<WeatherObserver> weatherObservers;

    public WeatherTracker() {
        this.weatherObservers = new ArrayList<WeatherObserver>();

        this.addDefaultObserver();
    }

    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;

        this.notifyAllObservers();
    }

    public String getCurrentCondition() {
        return this.currentConditions;
    }

    private void addDefaultObserver() {
        this.weatherObservers.add(new Phone());
        this.weatherObservers.add(new Emailer());
    }

    private void notifyAllObservers() {
        for (WeatherObserver weatherObserver : weatherObservers) {
            weatherObserver.notifyAboutWeather(this.currentConditions);
        }
    }

    public void addObserver(WeatherObserver observer) {
        this.weatherObservers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        this.weatherObservers.remove(observer);
    }
}
