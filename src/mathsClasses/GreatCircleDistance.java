package mathsClasses;

import java.util.Scanner;

public class GreatCircleDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for latitude and longitude of point 1
        System.out.print("Enter latitude of point 1 in degrees (north/south): ");
        double x1 = Math.toRadians(scanner.nextDouble());
        System.out.print("Enter longitude of point 1 in degrees (west/east): ");
        double y1 = Math.toRadians(scanner.nextDouble());

        // Prompt user for latitude and longitude of point 2
        System.out.print("Enter latitude of point 2 in degrees (north/south): ");
        double x2 = Math.toRadians(scanner.nextDouble());
        System.out.print("Enter longitude of point 2 in degrees (west/east): ");
        double y2 = Math.toRadians(scanner.nextDouble());

        // Earth's radius in kilometers
        double radius = 6371.01;

        // Calculate great circle distance
        double distance = radius * Math.acos(Math.sin(x1) * Math.sin(x2) +
                Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        System.out.printf("The great circle distance is: %.2f km", distance);
    }

}
