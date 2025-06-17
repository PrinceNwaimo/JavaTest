package diettel6;

import java.util.Scanner;

public class SportsRecommender {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the temperature in Celsius: ");
        double temperature = scanner.nextDouble();
        scanner.close();

        String recommendation = sportsRecommender(temperature);
        System.out.println(recommendation);
    }

    public static String sportsRecommender(double temperature) {
        if (temperature >= 20 && temperature <= 30) {
            return "It's lovely weather for sports today!";
        } else if (temperature >= 10 && temperature <= 40) {
            return "It's reasonable weather for sports today.";
        } else {
            return "Please exercise with care today, watch out for the weather!";
        }
    }

}
