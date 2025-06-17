package diettel6;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Temperature Conversion Options:");
        System.out.println("1. Celsius to Kelvin");
        System.out.println("2. Kelvin to Celsius");
        System.out.print("Enter your choice (1/2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                double celsius = scanner.nextDouble();
                double kelvin = celsiusToKelvin(celsius);
                System.out.printf("%.2f°C is equal to %.2fK%n", celsius, kelvin);
                break;
            case 2:
                System.out.print("Enter temperature in Kelvin: ");
                double kelvinInput = scanner.nextDouble();
                double celsiusResult = kelvinToCelsius(kelvinInput);
                System.out.printf("%.2fK is equal to %.2f°C%n", kelvinInput, celsiusResult);
                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

}
