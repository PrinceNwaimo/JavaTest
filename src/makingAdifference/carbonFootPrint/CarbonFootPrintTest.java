package makingAdifference.carbonFootPrint;

import java.util.ArrayList;

public class CarbonFootPrintTest {
    public static void main(String[] args) {
        ArrayList<CarbonFootprint> carbonFootprints = new ArrayList<>();

        Building building = new Building(10000, 50, true);
        Car car = new Car(15000, 25);
        Bicycle bicycle = new Bicycle();

        carbonFootprints.add(building);
        carbonFootprints.add(car);
        carbonFootprints.add(bicycle);

        for (CarbonFootprint footprint : carbonFootprints) {
            System.out.println(footprint.toString());
            System.out.println("Carbon Footprint: " + footprint.getCarbonFootprint() + " kg CO2");
            System.out.println();
        }
    }
}
