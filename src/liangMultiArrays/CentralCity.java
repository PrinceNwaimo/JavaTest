package liangMultiArrays;

import java.util.Scanner;

public class CentralCity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();

        double[][] cities = new double[n][2];
        System.out.println("Enter the coordinates of the cities:");
        for (int i = 0; i < n; i++) {
            cities[i][0] = scanner.nextDouble();
            cities[i][1] = scanner.nextDouble();
        }

        int centralCityIndex = findCentralCity(cities);
        double totalDistance = calculateTotalDistance(cities, centralCityIndex);

        System.out.println("The central city is at (" + cities[centralCityIndex][0] + ", " + cities[centralCityIndex][1] + ")");
        System.out.println("The total distance to all other cities is " + String.format("%.2f", totalDistance));
    }

    private static int findCentralCity(double[][] cities) {
        int centralCityIndex = 0;
        double minTotalDistance = Double.MAX_VALUE;

        for (int i = 0; i < cities.length; i++) {
            double totalDistance = calculateTotalDistance(cities, i);
            if (totalDistance < minTotalDistance) {
                minTotalDistance = totalDistance;
                centralCityIndex = i;
            }
        }

        return centralCityIndex;
    }

    private static double calculateTotalDistance(double[][] cities, int centralCityIndex) {
        double totalDistance = 0;
        for (int i = 0; i < cities.length; i++) {
            if (i != centralCityIndex) {
                totalDistance += distance(cities[centralCityIndex][0], cities[centralCityIndex][1], cities[i][0], cities[i][1]);
            }
        }
        return totalDistance;
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

}
