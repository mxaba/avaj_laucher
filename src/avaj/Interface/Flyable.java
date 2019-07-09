package avaj.Interface;

import avaj.Weather.WeatherTower;

/* Handle all the coordinates. */

public interface Flyable {

    //public-[absttract by default]-methods
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);

}
