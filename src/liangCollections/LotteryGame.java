package liangCollections;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryGame {
    public static void main(String[] args) {
        int lotteryNumber = (int) (Math.random() * 1000);
        String lotteryNumberStr = String.format("%03d", lotteryNumber);

        int[] lotteryDigits = new int[3];
        for (int i = 0; i < 3; i++) {
            lotteryDigits[i] = lotteryNumberStr.charAt(i) - '0';
        }
        Arrays.sort(lotteryDigits);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your lottery pick (three digits): ");
        int userInput = scanner.nextInt();
        String userInputStr = String.format("%03d", userInput);

        int[] userDigits = new int[3];
        for (int i = 0; i < 3; i++) {
            userDigits[i] = userInputStr.charAt(i) - '0';
        }
        Arrays.sort(userDigits);

        int matchCount = 0;
        for (int i = 0; i < 3; i++) {
            if (lotteryDigits[i] == userDigits[i]) {
                matchCount++;
            }
        }

        int commonDigits = 0;
        for (int digit : userDigits) {
            for (int lotteryDigit : lotteryDigits) {
                if (digit == lotteryDigit) {
                    commonDigits++;
                    break;
                }
            }
        }

        int award = 0;
        if (matchCount == 3) {
            award = 10000;
        } else if (matchCount == 2) {
            award = 1000;
        } else if (commonDigits >= 2) {
            award = 2000;
        } else if (matchCount == 1) {
            award = 1000 / 10;
        }

        System.out.println("The lottery number is " + lotteryNumberStr);
        if (award > 0) {
            System.out.println("Congratulations! You won $" + award);
        } else {
            System.out.println("Sorry, you didn't win");
        }
    }
}
