package mathsClasses;

import java.util.Scanner;

public class LetterGradeToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a letter grade (A, B, C, D, or F): ");
        String grade = scanner.next().toUpperCase();

        switch (grade) {
            case "A":
                System.out.println("The numeric value of A is 4");
                break;
            case "B":
                System.out.println("The numeric value of B is 3");
                break;
            case "C":
                System.out.println("The numeric value of C is 2");
                break;
            case "D":
                System.out.println("The numeric value of D is 1");
                break;
            case "F":
                System.out.println("The numeric value of F is 0");
                break;
            default:
                System.out.println("Invalid grade. Please enter A, B, C, D, or F.");
        }
    }

}
