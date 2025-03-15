package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChampionshipManager {
private static ChampionshipManager instance;
private List<Driver> drivers;
private List<RallyRaceResult> race;
private static int totalDrivers = 0;
private static int totalRaces = 0;

private ChampionshipManager(){
    this.drivers = new ArrayList<>();
    this.race = new ArrayList<>();

}

public static ChampionshipManager getInstance(){
    if (instance == null) {
        instance = new ChampionshipManager();
    }
    return instance;
}

public void registerDriver(Driver driver){
    drivers.add(driver);
    totalDrivers++;

}

public void addRaceResult(RallyRaceResult result){
    race.add(result);
    totalRaces++;

}

public List<Driver> getDriverstandings(){
    drivers.sort(Comparator.comparingInt(Driver::getPoints).reversed());
    return drivers;
}

public static Driver getLeadingDriver(List<Driver> drivers){
    Driver topDriver = null;
    for (Driver d : drivers) {
        if (topDriver == null || d.getPoints() > topDriver.getPoints()) {
        topDriver = d;
    }
}
    return topDriver;
}

public static int getTotalChampionshipPoints(){
    ChampionshipManager manager = ChampionshipManager.getInstance();
    int totalPoints = 0;
    for (Driver d : manager.drivers)  {
        totalPoints += d.getPoints();  
        }
    return totalPoints;
}
public static int getTotalRacesHeld(){
        return totalRaces;
}

public static int getTotalDrivers(){
        return totalDrivers;
}
}
