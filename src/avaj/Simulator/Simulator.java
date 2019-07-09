package avaj.Simulator;

import avaj.Aircrafts.AircraftFactory;
import avaj.Exceptions.UsageException;
import avaj.Exceptions.EmptyFileException;
import avaj.Interface.Flyable;
import avaj.Weather.WeatherTower;
import java.util.*;
import java.io.*;

public class Simulator {

    //private-properties
    private static WeatherTower weatherTower;
    private static List<Flyable> aircraftList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

                BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                String str = reader.readLine();
            if (str != null) {
                weatherTower = new WeatherTower();
                int sim = Integer.parseInt(str.split(" ")[0]);
                while ((str = reader.readLine()) != null) {
                    String[] params = str.split(" ");
                    
                    if (params.length == 5) {
                        String[] arg = str.split(" ");
                        Flyable flyable = AircraftFactory.newAircraft(
                            arg[0], arg[1], 
                            Integer.parseInt(arg[2]), 
                            Integer.parseInt(arg[3]),
                            Integer.parseInt(arg[4]));
                        aircraftList.add(flyable);
                    } else {
                        System.out.println((char)27 + "[33mError: Each line of the file, except the first one, should look like this: [TYPE NAME LONGITUDE LATITUDE HEIGHT]" + (char)27 + "[0m");
                        System.exit(1);
                    }
                }

                for (Flyable flyable : aircraftList) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= sim; i++) {
                    String simToWrite = "\nSimulation: " + i + "\n";
                    weatherTower.writeToFile("write", simToWrite);
                    weatherTower.changeWeather();
                }
                reader.close();
            }
    }

}
