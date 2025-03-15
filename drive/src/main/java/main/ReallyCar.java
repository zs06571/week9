package main;

public abstract class ReallyCar {
    private String make;
    private String model;
    private int horsepower;

    public ReallyCar(String make, String model, int horsepower){
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getHorsepower(){
        return horsepower;
    }

    public interface InnerReallyCar {
        double calculate(ReallyCar car);
    } 

}
