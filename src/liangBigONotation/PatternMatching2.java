package liangBigONotation;

import java.util.Scanner;

public class PatternMatching2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String s2 = scanner.nextLine();

        if (isSubstring(s1, s2)) {
            System.out.println(s2 + " is a substring of " + s1);
        } else {
            System.out.println(s2 + " is not a substring of " + s1);
        }
    }

    public static boolean isSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && s1.charAt(i + j) == s2.charAt(j)) {
                j++;
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }
}
