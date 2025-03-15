package main;
import java.util.List;

import main.ReallyCar.InnerReallyCar;

public class Main 
{
    public static void main( String[] args )
    {
        ChampionshipManager manager = ChampionshipManager.getInstance();
        GravelCar g = new GravelCar("iron", "suv", 34, 83);
        AsphaltCar a = new AsphaltCar("aluminium", "suv", 63, 98);

        Driver d1 = new Driver("Sébastien Ogier", "France", null);
        Driver d2 = new Driver("Kalle Rovanperä", "Finland", null);
        Driver d3 = new Driver("Ott Tänakr", "Estonia", null);
        Driver d4 = new Driver("Thierry Neuville", "Belgium", null);
        manager.registerDriver(d1);
        manager.registerDriver(d2);
        manager.registerDriver(d3);
        manager.registerDriver(d4);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        d1.setCar(g);
        d2.setCar(g);
        d3.setCar(g);
        d4.setCar(g);
        race1.recordResult(d1, 1, 25);
        race1.recordResult(d3, 2, 18);
        race1.recordResult(d2, 3, 15);
        race1.recordResult(d4, 4, 12);
        manager.addRaceResult(race1);
       
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        d1.setCar(a);
        d2.setCar(a);
        d3.setCar(a);
        d4.setCar(a);
        race2.recordResult(d2, 1, 25);
        race2.recordResult(d4, 2, 18);
        race2.recordResult(d1, 3, 15);
        race2.recordResult(d3, 4, 12);
        manager.addRaceResult(race2);

        GravelCar.InnerGravelCar Gravelcalculate = g.new InnerGravelCar();
        AsphaltCar.InnerAsphaltCar Asphaltcalculate = a.new InnerAsphaltCar();

        List<Driver> finaList = manager.getDriverstandings();
        int i = 0;
        for (Driver driver: finaList) {
            i++;
            System.out.println(i + ". " + driver.getName() + " (" + driver.getCountry() + ") : " + driver.getPoints() + " points" );
            }
        System.out.println("===== CHAMPIONSHIP LEADER =====");
        Driver topDriver = ChampionshipManager.getLeadingDriver(finaList);
        System.err.println(topDriver.getName() + " with " + topDriver.getPoints() + " points"); 
        System.out.println();
        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        int totalDrivers = ChampionshipStatistics.getTotalDrivers();
        int totalRaces = ChampionshipStatistics.getTotalRacesHeld();
        String findSuccessfulCountry = ChampionshipStatistics.findMostSuccessfulCountry(finaList);
        int totalPoints = ChampionshipManager.getTotalChampionshipPoints();
        System.out.println("Total Drivers: " + totalDrivers);
        System.out.println("Total Races: " + totalRaces);
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(finaList));
        System.out.println("Most Successful Country: " + findSuccessfulCountry);
        System.out.println("Total Championship Points: " + totalPoints);
        System.out.println();
        System.out.println("===== RACE RESULTS =====");
        System.out.println("Race: " + race1.getRaceName() + " (" + race1.getLocation() + ")");
        List<Driver> race1List = race1.getResults();
        int i1 = 0;
        for (Driver driver: race1List) {
            i1++;
            System.out.println("Position " + i1 + ": " + driver.getName() + " - " + race1.getDriverPoints(driver) + " points");
        }
        System.out.println();

        System.out.println("Race: " + race2.getRaceName() + " (" + race2.getLocation() + ")");
        List<Driver> race2List = race2.getResults();
        int i2 = 0;
        for (Driver driver: race2List) {
            i2++;
            System.out.println("Position " + i2 + ": " + driver.getName() + " - " + race2.getDriverPoints(driver) + " points");
    }
        System.out.println();
        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + Gravelcalculate.calculate(g));  
        System.out.println("Asphalt Car Performance: " + Asphaltcalculate.calculate(a));

}
}

