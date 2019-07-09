package avaj.Aircrafts;

import avaj.Interface.Flyable;
import avaj.Weather.WeatherTower;

/* Handle Helicopter aircraft. */

public class Helicopter extends Aircraft implements Flyable {

    //private-properties
    private WeatherTower weatherTower;

    //private-variables
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    //public-methods
    public void updateConditions() {
        String weatherType = weatherTower.getWeather(this.coordinates);
        String toFile = "";
        String toFileUnreg = "";
        String tmp = "Helicopter#" + this.name + "(" + this.id + "): ";

        switch (weatherType) {
            case "RAIN":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 5, 
                    coordinates.getLatitude(), 
                    coordinates.getHeight());
                toFile = tmp + "This rain is so depressing...\n";
                break;
            case "SUN":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 10, 
                    coordinates.getLatitude(), 
                    coordinates.getHeight() + 2);
                toFile = tmp + "It's so hot!\n";
                break;
            case "FOG":
                coordinates = new Coordinates(
                    coordinates.getLongitude(), 
                    coordinates.getLatitude(), 
                    coordinates.getHeight() - 3);
                toFile = tmp + "I see no ground!\n";
                break;
            case "SNOW":
                coordinates = new Coordinates(
                    coordinates.getLongitude(), 
                    coordinates.getLatitude(), 
                    coordinates.getHeight() - 12);
                toFile = tmp + "Winter is coming!\n";
                break;
        }

        weatherTower.writeToFile("write", toFile);

        if (this.coordinates.getHeight() <= 0) {
            toFileUnreg = "avaj.Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.\n";
            weatherTower.writeToFile("write", toFileUnreg);
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        String write = "avaj.Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.\n";
        this.weatherTower = weatherTower;
        weatherTower.writeToFile("write", write);
    }

}