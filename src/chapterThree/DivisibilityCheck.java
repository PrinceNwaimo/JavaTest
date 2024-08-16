package chapterThree;

import java.util.Scanner;

public class DivisibilityCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = input.nextInt();

        boolean divisibleBy5And6 = (num % 5 == 0) && (num % 6 == 0);
        boolean divisibleBy5Or6 = (num % 5 == 0) || (num % 6 == 0);
        boolean divisibleBy5Or6ButNotBoth = (num % 5 == 0) ^ (num % 6 == 0);

        System.out.println("Divisible by 5 and 6: " + divisibleBy5And6);
        System.out.println("Divisible by 5 or 6: " + divisibleBy5Or6);
        System.out.println("Divisible by 5 or 6, but not both: " + divisibleBy5Or6ButNotBoth);
    }

}
