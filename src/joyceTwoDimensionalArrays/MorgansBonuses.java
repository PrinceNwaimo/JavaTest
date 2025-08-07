package joyceTwoDimensionalArrays;

import java.util.Scanner;

public class MorgansBonuses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the number of full weeks worked: ");
            int weeksWorked = scanner.nextInt();

            System.out.print("Enter the number of positive online customer reviews: ");
            int positiveReviews = scanner.nextInt();

            double bonus = calculateBonus(weeksWorked, positiveReviews);
            System.out.println("The bonus is: $" + bonus);

            System.out.print("Do you want to continue? (yes/no): ");
            scanner.nextLine(); // Consume newline left-over
            String response = scanner.nextLine().toLowerCase();

            if (!response.equals("yes")) {
                break;
            }
        }
    }

    private static double calculateBonus(int weeksWorked, int positiveReviews) {
        if (weeksWorked < 0 || positiveReviews < 0) {
            return 0;
        }

        double[][] bonuses = {
                {5.00, 9.00, 16.00, 22.00, 30.00},
                {10.00, 12.00, 18.00, 24.00, 36.00},
                {20.00, 25.00, 32.00, 42.00, 53.00},
                {32.00, 38.00, 45.00, 55.00, 68.00},
                {46.00, 54.00, 65.00, 77.00, 90.00},
                {60.00, 72.00, 84.00, 96.00, 120.00},
                {85.00, 100.00, 120.00, 140.00, 175.00}
        };

        int weeksIndex = Math.min(weeksWorked, 6);
        int reviewsIndex = Math.min(positiveReviews, 4);

        return bonuses[weeksIndex][reviewsIndex];
    }

}
