package avaj.Weather;

import avaj.Aircrafts.Coordinates;
import java.util.Random;

/* This will handle all different kinds of weathers. */

public class WeatherProvider {

    //private-properties
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    //constructor-for-private
    private WeatherProvider() {
    }

    //public-methods
    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int generator = new Random().nextInt(weather.length);
        generator = (coordinates.getHeight() > 20) ? generator++ : generator--;
        generator = (generator < 0) ? 3 : generator;
        generator = (generator > 3) ? 0 : generator;
        return weather[generator];
    }

}
