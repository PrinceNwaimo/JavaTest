package diettel4;

import java.util.Scanner;

public class GasMileage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalMiles = 0;
        int totalGallons = 0;
        int counter = 0;
        System.out.print("Miles driven or press -1 to exit: ");
        int miles = input.nextInt();
        System.out.print("Gallons used or press -1 to exit: ");
        int gallons = input.nextInt();
        double average = (double) miles/gallons;
        System.out.printf("%n The miles per gallon for this trip is %.2f%n",average);

        while(miles != -1 && gallons != -1){

            totalMiles+= miles;
            totalGallons+=gallons;
            System.out.print("Miles driven or press -1 to exit: ");
            miles = input.nextInt();
            System.out.print("Gallons used or press -1 to exit: ");
            gallons = input.nextInt();

            average = (double)miles/gallons;

            System.out.printf("%n The miles per gallon for this trip is %.2f%n",average);
            counter++;
        }
        if(counter != 0){
            double averageTrips = (double) totalMiles/totalGallons;
            System.out.printf("%n The average miles per gallon for %d trips is %.2f%n",counter,averageTrips);
        }
        else{
            System.out.println("No input made");
        }

    }
}
