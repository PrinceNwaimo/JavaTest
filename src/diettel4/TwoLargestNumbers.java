package diettel4;

import java.util.Scanner;

public class TwoLargestNumbers {
    public static void main(String[] args) {
        int counter = 0;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);

        while (counter < 10) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest) {
                secondLargest = number;
            }

            counter++;
        }

        System.out.println("The largest number is: " + largest);
        System.out.println("The second largest number is: " + secondLargest);
    }

}
