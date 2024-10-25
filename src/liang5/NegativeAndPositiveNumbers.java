package liang5;

import java.util.Scanner;

public class NegativeAndPositiveNumbers {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

        int positiveCounter = 0;
        int negativeCounter = 0;
        double total = 0;
        int nonZeroCount = 0;



        while (true){
            System.out.print("Enter an integer (0 to stop): ");
            int number = input.nextInt();


            if (number == 0){
                break;
            }
            if(number > 0){
                positiveCounter++;
            } else if (number < 0) {
                negativeCounter++;

            }
            total += number;
            nonZeroCount++;

        }
        System.out.println("The number of positives is "+ positiveCounter);
        System.out.println("The number of negatives is "+ negativeCounter);
        System.out.println("Total is : "+ total);
        System.out.println("Average (excluding zeros): "+ (nonZeroCount > 0 ? total / nonZeroCount : 0));

    }
}
