package liangBigONotation;

import java.util.Scanner;

public class MaxConsecutiveIncreasingSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        String maxSubstring = "";
        String currentSubstring = "" + s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                currentSubstring += s.charAt(i);
            } else {
                if (currentSubstring.length() > maxSubstring.length()) {
                    maxSubstring = currentSubstring;
                }
                currentSubstring = "" + s.charAt(i);
            }
        }

        if (currentSubstring.length() > maxSubstring.length()) {
            maxSubstring = currentSubstring;
        }

        System.out.println("The maximum consecutive increasingly ordered substring is " + maxSubstring);
    }
}
