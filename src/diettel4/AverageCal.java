package diettel4;

import java.util.Scanner;

public class AverageCal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;
        int counter = 1;

        while (counter <= 5) {
            System.out.print("Enter the amount of money: ");
            int amount = input.nextInt();
            total = total + amount;
            counter = counter + 1;
        }
        if (counter != 0) {

            double average = (double) total / counter;
            System.out.printf("%n The total amount is %d%n", total);
            System.out.printf("The average amount is %.2f%n", average);
        }
        else {
            System.out.println("No input yet");
        }
    }
}
