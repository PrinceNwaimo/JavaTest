package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckSortedStrings {
    public static void main(String[] args) {
        String filename = "SortedStrings.txt";
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            String previousString = scanner.next();
            boolean sorted = true;

            while (scanner.hasNext()) {
                String currentString = scanner.next();
                if (currentString.compareTo(previousString) < 0) {
                    System.out.println("The strings are not sorted.");
                    System.out.println("The first two strings out of order are:");
                    System.out.println(previousString);
                    System.out.println(currentString);
                    sorted = false;
                    break;
                }
                previousString = currentString;
            }

            if (sorted) {
                System.out.println("The strings are sorted.");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}
