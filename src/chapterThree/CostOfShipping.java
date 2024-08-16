package chapterThree;

import java.util.Scanner;

public class CostOfShipping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the weight of the package: ");
        double weight = input.nextDouble();

        if( 0 < weight && weight<= 1)
            System.out.println("Pay $3.5");
        else if (1 < weight && weight <= 3) {
            System.out.println("Pay $5.5");
        } else if (3 < weight && weight <= 10) {
            System.out.println("Pay $8.5");
        } else if (10 < weight && weight <= 20) {
            System.out.println("Pay $10.5");
        }
        else {
            System.out.println("The package cannot be shipped");
        }
    }
}
