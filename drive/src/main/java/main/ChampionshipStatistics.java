package main;

import java.util.Comparator;
import java.util.List;

public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers){
        return drivers.stream()
                      .mapToInt(Driver::getPoints)  
                      .average()                   
                      .orElse(0);  
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers){
         Driver topDriver = drivers.stream()
                .max(Comparator.comparingInt(Driver::getPoints))
                .orElseThrow();
        return topDriver.getCountry();

    }
    public static int getTotalRacesHeld(){
        return ChampionshipManager.getTotalRacesHeld();
}
public static int getTotalDrivers(){
    return ChampionshipManager.getTotalDrivers();
}
    

    

}
