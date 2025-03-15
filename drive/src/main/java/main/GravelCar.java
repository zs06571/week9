package main;

public class GravelCar extends ReallyCar{
    private double suspensionTravel;
    public GravelCar(String make, String model, int horsepower, double suspensionTravel){
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;

    }

    public double getSuspensionTravel(){
        return suspensionTravel;
    }

    public class InnerGravelCar implements InnerReallyCar{
        public double calculate(ReallyCar car){
            return car.getHorsepower() * suspensionTravel;
        }
    
        
    } 

}
