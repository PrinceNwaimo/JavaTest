package mathsClasses;

import java.util.Scanner;

public class LetterToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a letter: ");
        String input = scanner.next().toUpperCase();

        if (input.length() == 1) {
            char letter = input.charAt(0);

            switch (letter) {
                case 'A':
                case 'B':
                case 'C':
                    System.out.println(letter + " corresponds to 2");
                    break;
                case 'D':
                case 'E':
                case 'F':
                    System.out.println(letter + " corresponds to 3");
                    break;
                case 'G':
                case 'H':
                case 'I':
                    System.out.println(letter + " corresponds to 4");
                    break;
                case 'J':
                case 'K':
                case 'L':
                    System.out.println(letter + " corresponds to 5");
                    break;
                case 'M':
                case 'N':
                case 'O':
                    System.out.println(letter + " corresponds to 6");
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    System.out.println(letter + " corresponds to 7");
                    break;
                case 'T':
                case 'U':
                case 'V':
                    System.out.println(letter + " corresponds to 8");
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    System.out.println(letter + " corresponds to 9");
                    break;
                default:
                    System.out.println(letter + " is not a letter.");
            }
        } else {
            System.out.println("Please enter a single letter.");
        }
    }

}
