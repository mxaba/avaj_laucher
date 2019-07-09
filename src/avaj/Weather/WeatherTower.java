package avaj.Weather;

import avaj.Tower.Tower;
import avaj.Aircrafts.Coordinates;

/* This will handle all the coordinates. */

public class WeatherTower extends Tower {

    //public-methods
    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    //default-methods
    public void changeWeather() {
        this.conditionsChanged();
    }
}