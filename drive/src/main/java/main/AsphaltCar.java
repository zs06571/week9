package main;

public class AsphaltCar extends ReallyCar{
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce){
        super(make, model, horsepower);
        this.downforce = downforce;

    }

    public double getDownforce(){
        return downforce;
    }

    public class InnerAsphaltCar implements InnerReallyCar{
        public double calculate(ReallyCar car){
            return car.getHorsepower() * downforce;
        }
    
        
    } 
    }


