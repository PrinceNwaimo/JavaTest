package sortAlgorithms;

import java.util.Scanner;

public class SortingIntegers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three integers: ");
        int firstNumber = input.nextInt();
        int secondNumber = input.nextInt();
        int thirdNumber = input.nextInt();

        int temporaryHolder;
        if (firstNumber > secondNumber){
            temporaryHolder = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temporaryHolder;
        }

        if (firstNumber > thirdNumber){
            temporaryHolder = firstNumber;
            firstNumber = thirdNumber;
            thirdNumber = temporaryHolder;
        }
        if (secondNumber > thirdNumber){
            temporaryHolder = secondNumber;
            secondNumber = thirdNumber;
            thirdNumber = temporaryHolder;
        }
        System.out.println(firstNumber +","+ secondNumber+","+thirdNumber);
    }
}
