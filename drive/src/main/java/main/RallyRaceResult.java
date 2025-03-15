package main;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class RallyRaceResult implements RaceResult{
    private String raceName;
    private String location;
    private Map<Driver, Integer> result;

    public RallyRaceResult(String raceName, String location){
        this.raceName = raceName;
        this.location = location;
        this.result = new HashMap<>();
    }

    public String getRaceName(){
        return raceName;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points){
        result.put(driver, points);
        driver.addPoints(points);  
    }
 
    @Override
    public int getDriverPoints(Driver driver){
        return result.get(driver);
    }

    @Override
    public List<Driver> getResults(){
        List<Driver> driversList = new ArrayList<>(result.keySet());
        Collections.sort(driversList, new Comparator<Driver>() {
            @Override
            public int compare(Driver driver1, Driver driver2) {
                return Integer.compare(result.get(driver2), result.get(driver1));
            }
        });

        return driversList;
        
    }


}
