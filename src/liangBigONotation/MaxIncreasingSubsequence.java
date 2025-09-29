package liangBigONotation;

import java.util.Scanner;

public class MaxIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        int[] dp = new int[s.length()];
        int[] prev = new int[s.length()];
        int maxLength = 1;
        int maxLengthIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) > s.charAt(j) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxLengthIndex = i;
            }
        }

        StringBuilder maxSubsequence = new StringBuilder();
        while (maxLengthIndex != -1) {
            maxSubsequence.insert(0, s.charAt(maxLengthIndex));
            maxLengthIndex = prev[maxLengthIndex];
        }

        System.out.println("The maximum increasingly ordered subsequence is " + maxSubsequence);
    }
}
