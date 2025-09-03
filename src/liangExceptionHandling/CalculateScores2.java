package liangExceptionHandling;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class CalculateScores2 {
    public static void main(String[] args) {
        String url = "http://cs.armstrong.edu/liang/data/Scores.txt";
        try {
            URL scoresUrl = new URL(url);
            Scanner scanner = new Scanner(scoresUrl.openStream());
            double total = 0;
            int count = 0;

            while (scanner.hasNextDouble()) {
                total += scanner.nextDouble();
                count++;
            }

            scanner.close();

            if (count == 0) {
                System.out.println("No scores found.");
            } else {
                double average = total / count;
                System.out.println("Total: " + total);
                System.out.println("Average: " + average);
            }
        } catch (IOException e) {
            System.out.println("Error reading from URL: " + url);
        }
    }
}
