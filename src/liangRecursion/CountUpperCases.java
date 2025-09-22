package liangRecursion;

import java.util.Scanner;

public class CountUpperCases {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        int count = countUppercase(str);
        System.out.println("The number of uppercase letters is: " + count);
    }

    public static int countUppercase(String str) {
        if (str.isEmpty()) {
            return 0;
        } else if (Character.isUpperCase(str.charAt(0))) {
            return 1 + countUppercase(str.substring(1));
        } else {
            return countUppercase(str.substring(1));
        }
    }
}
