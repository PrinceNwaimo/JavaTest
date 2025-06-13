package liangChapter6;

import java.util.Scanner;

public class PhoneKeypad {
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
                result.append(getNumber(Character.toUpperCase(c) % 65));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static char getNumber(int n) {
        switch (n) {
            case 65: case 66: case 67: return '2';
            case 68: case 69: case 70: return '3';
            case 71: case 72: case 73: return '4';
            case 74: case 75: case 76: return '5';
            case 77: case 78: case 79: return '6';
            case 80: case 81: case 82: case 83: return '7';
            case 84: case 85: case 86: return '8';
            case 87: case 88: case 89: return '9';
            default: return ' ';
        }
    }

}
