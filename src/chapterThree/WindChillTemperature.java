package chapterThree;

import java.util.Scanner;

public class WindChillTemperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter the temperature in Fahrenheit between −58°F and 41°F: ");
        double temperature = input.nextDouble();


        System.out.print("Enter the wind speed (>=2) in miles per hour: ");
        double windSpeed = input.nextDouble();


        if (temperature >= -58 && temperature <= 41 && windSpeed >= 2) {

            double windChill = 35.74 + 0.6215 * temperature - 35.75 * Math.pow(windSpeed, 0.16)
                    + 0.4275 * temperature * Math.pow(windSpeed, 0.16);


            System.out.printf("The wind-chill temperature is %.2f°F%n", windChill);
        } else {
            if (temperature < -58 || temperature > 41) {
                System.out.println("Error: The temperature must be between −58°F and 41°F.");
            }
            if (windSpeed < 2) {
                System.out.println("Error: The wind speed must be greater than or equal to 2 mph.");
            }
        }
    }
}
