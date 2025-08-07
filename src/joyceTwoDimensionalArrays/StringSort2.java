package joyceTwoDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class StringSort2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[15];
        int count = 0;

        System.out.println("Enter strings (up to 15):");
        while (count < 15) {
            System.out.print("Enter string (or 'done' to finish): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            strings[count] = input;
            count++;
        }

        String[] trimmedStrings = Arrays.copyOf(strings, count);
        Arrays.sort(trimmedStrings);

        System.out.println("Sorted Strings:");
        for (String str : trimmedStrings) {
            System.out.println(str);
        }
    }

}
