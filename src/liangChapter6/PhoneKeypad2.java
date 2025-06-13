package liangChapter6;

import java.util.Scanner;

public class PhoneKeypad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        scanner.close();

        System.out.println(getNumber(s));
    }

    public static String getNumber(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(getNumber(Character.toUpperCase(c)));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static char getNumber(char c) {
        if (c >= 'A' && c <= 'C') return '2';
        else if (c >= 'D' && c <= 'F') return '3';
        else if (c >= 'G' && c <= 'I') return '4';
        else if (c >= 'J' && c <= 'L') return '5';
        else if (c >= 'M' && c <= 'O') return '6';
        else if (c >= 'P' && c <= 'S') return '7';
        else if (c >= 'T' && c <= 'V') return '8';
        else if (c >= 'W' && c <= 'Z') return '9';
        else return c;
    }

}
