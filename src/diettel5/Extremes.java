package diettel5;

import java.util.Scanner;

public class Extremes {
    public static void main(String[] args) {

        int counter = 0;
        int largest = Integer.MAX_VALUE;
        int smallest =  Integer.MIN_VALUE;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of values to be entered: ");
        int number = input.nextInt();

        for (int i = 0; i < number; i++) {
            counter++;

        }
    }
}
