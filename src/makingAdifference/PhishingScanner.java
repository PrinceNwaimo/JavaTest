package makingAdifference;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhishingScanner {
    private static final Map<String, Integer> phishingTerms = new HashMap<>();

    static {
        phishingTerms.put("login", 2);
        phishingTerms.put("password", 3);
        phishingTerms.put("credit card", 3);
        phishingTerms.put("social security number", 3);
        phishingTerms.put("paypal", 2);
        phishingTerms.put("bank", 2);
        phishingTerms.put("account", 2);
        phishingTerms.put("verify", 2);
        phishingTerms.put("update", 2);
        phishingTerms.put("confirm", 2);
        phishingTerms.put("security", 2);
        phishingTerms.put("alert", 2);
        phishingTerms.put("warning", 2);
        phishingTerms.put("urgent", 2);
        phishingTerms.put("click here", 3);
        phishingTerms.put("login now", 3);
        phishingTerms.put("update now", 3);
        phishingTerms.put("confirm your account", 3);
        phishingTerms.put("verify your account", 3);
        phishingTerms.put("enter your password", 3);
        phishingTerms.put("enter your credit card number", 3);
        phishingTerms.put("your account has been compromised", 3);
        phishingTerms.put("your account will be suspended", 3);
        phishingTerms.put("your password has expired", 3);
        phishingTerms.put("your account needs to be updated", 3);
        phishingTerms.put("facebook", 2);
        phishingTerms.put("twitter", 2);
        phishingTerms.put("linkedin", 2);
        phishingTerms.put("bank of america", 3);
        phishingTerms.put("wells fargo", 3);
        phishingTerms.put("chase bank", 3);
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("words.txt"));
            scanner.useDelimiter("\\Z");
            String emailContent = scanner.next();
            scanner.close();

            Map<String, Integer> termCount = new HashMap<>();
            int totalPoints = 0;

            for (Map.Entry<String, Integer> entry : phishingTerms.entrySet()) {
                String term = entry.getKey();
                int points = entry.getValue();
                int count = countOccurrences(emailContent.toLowerCase(), term.toLowerCase());

                if (count > 0) {
                    termCount.put(term, count);
                    totalPoints += count * points;
                    System.out.println(term + ": " + count + " occurrences, " + count * points + " points");
                }
            }

            System.out.println("Total points: " + totalPoints);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    private static int countOccurrences(String text, String term) {
        int count = 0;
        int index = text.indexOf(term);

        while (index != -1) {
            count++;
            index = text.indexOf(term, index + term.length());
        }

        return count;
    }
}
