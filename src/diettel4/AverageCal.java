package diettel4;

import java.util.Scanner;

public class AverageCal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;
        int counter = 1;

        while (counter <= 5){
            System.out.print("Enter the amount of money: ");
            int amount = input.nextInt();
            total = total + amount;
            counter = counter + 1;
        }
        System.out.printf("%n The total amount is %d%n", total);
    }
}
