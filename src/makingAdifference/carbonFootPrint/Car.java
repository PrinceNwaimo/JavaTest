package makingAdifference.carbonFootPrint;

public class Car implements CarbonFootprint {
    private double milesDriven;
    private double fuelEfficiency;

    public Car(double milesDriven, double fuelEfficiency) {
        this.milesDriven = milesDriven;
        this.fuelEfficiency = fuelEfficiency;
    }

    @Override
    public double getCarbonFootprint() {
        double gallonsConsumed = milesDriven / fuelEfficiency;
        return gallonsConsumed * 8.81;
    }

    @Override
    public String toString() {
        return "Car - Miles Driven: " + milesDriven + ", Fuel Efficiency: " + fuelEfficiency + " miles/gallon";
    }
}
