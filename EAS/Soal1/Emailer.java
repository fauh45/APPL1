package Soal1;

public class Emailer implements WeatherObserver {
    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;

        return alert;
    }

    @Override
    public void notifyAboutWeather(String weatherConditions) {
        if (weatherConditions == "sunny") {
            System.out.println(this.generateWeatherAlert(weatherConditions));
        }
    }
}
