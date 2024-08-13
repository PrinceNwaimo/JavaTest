package sortAlgorithms;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a three-digit integer: ");
        int digit = input.nextInt();
        int digit1 = digit / 100;
        int digit2 = digit % 10;

        if (digit1 == digit2)
            System.out.println("This is a palindrome");
        else{
            System.out.println("This is not a palindrome");
        }
    }
}
