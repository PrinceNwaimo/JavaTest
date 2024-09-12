package diettel4;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int counter = 1;
        int largest = 0;

        while(counter <= 10){
            System.out.print("Enter a number: ");
            int number = input.nextInt();
            if(number > largest){
                largest = number;
            }
            counter++;
        }
        System.out.printf("The largest number is: %d ", largest);
    }
}
