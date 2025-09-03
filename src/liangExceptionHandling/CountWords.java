package liangExceptionHandling;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        String url = "http://cs.armstrong.edu/liang/data/Lincoln.txt";

        try {
            URL lincolnUrl = new URL(url);
            Scanner scanner = new Scanner(lincolnUrl.openStream());
            int wordCount = 0;

            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }

            scanner.close();
            System.out.println("Word count: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading from URL: " + url);
        }
    }
}
