package liangArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SortString {
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        System.out.println("Sorted string: " + sort(s));
    }

}
