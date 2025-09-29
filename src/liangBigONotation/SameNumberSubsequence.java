package liangBigONotation;

import java.util.Scanner;

public class SameNumberSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of integers ending with 0: ");
        int currentNumber = scanner.nextInt();
        int maxLength = 1;
        int currentLength = 1;
        int maxNumber = currentNumber;

        while ((currentNumber = scanner.nextInt()) != 0) {
            if (currentNumber == maxNumber) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                maxNumber = currentNumber;
                currentLength = 1;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxNumber = currentNumber;
        }

        System.out.println("The longest same number subsequence is " + maxLength + " " + maxNumber + "'s");
    }
}
