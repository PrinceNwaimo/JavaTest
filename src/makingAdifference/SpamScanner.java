package makingAdifference;

import java.util.Scanner;

public class SpamScanner {
    private static final String[] spamKeywords = {
            "free", "win", "prize", "click", "here", "now", "limited", "time", "offer",
            "buy", "now", "cheap", "discount", "guaranteed", "make", "money", "fast",
            "cash", "loans", "debt", "relief", "weight", "loss", "diet", "pills",
            "viagra", "cialis", "online", "pharmacy", "casino", "gambling", "sex",
            "hot", "girls", "nude", "pics", "xxx"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an email message: ");
        String message = scanner.nextLine().toLowerCase();
        scanner.close();

        int spamScore = calculateSpamScore(message);
        System.out.println("Spam score: " + spamScore);
        System.out.println(getSpamRating(spamScore));
    }

    private static int calculateSpamScore(String message) {
        int spamScore = 0;
        for (String keyword : spamKeywords) {
            if (message.contains(keyword)) {
                spamScore++;
            }
        }
        return spamScore;
    }

    private static String getSpamRating(int spamScore) {
        if (spamScore == 0) {
            return "Not spam";
        } else if (spamScore <= 3) {
            return "Low likelihood of spam";
        } else if (spamScore <= 6) {
            return "Moderate likelihood of spam";
        } else {
            return "High likelihood of spam";
        }
    }
}
