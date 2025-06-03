package characterAndStrings;

import java.util.Arrays;
import java.util.Scanner;

public class Alphabetize2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();

        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();

        System.out.println("Enter the third string:");
        String str3 = scanner.nextLine();

        String[] strings = {str1, str2, str3};
        Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);

        System.out.println("The strings in alphabetical order are:");
        for (String str : strings) {
            System.out.println(str);
        }

        scanner.close();
    }


}
