package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RankingSummary {
    public static void main(String[] args) {
        System.out.println("Year\tRank 1\tRank 2\tRank 3\tRank 4\tRank 5\tRank 1\tRank 2\tRank 3\tRank 4\tRank 5");
        System.out.println("\t(Girls)\t\t\t\t\t\t\t\t(Boys)");
        for (int year = 2010; year >= 2001; year--) {
            String filename = "babynameranking" + year + ".txt";
            try {
                File file = new File(filename);
                Scanner fileScanner = new Scanner(file);
                System.out.print(year + "\t");
                for (int i = 0; i < 5; i++) {
                    String[] line = fileScanner.nextLine().split("\\s+");
                    System.out.print(line[3] + "\t");
                }
                fileScanner.close();
                fileScanner = new Scanner(new File(filename));
                for (int i = 0; i < 5; i++) {
                    String[] line = fileScanner.nextLine().split("\\s+");
                    System.out.print(line[1] + "\t");
                }
                fileScanner.close();
                System.out.println();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
            }
        }
    }
}
