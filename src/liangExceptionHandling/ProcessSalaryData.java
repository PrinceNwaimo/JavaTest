package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessSalaryData {
    public static void main(String[] args) {
        String url = "http://cs.armstrong.edu/liang/data/Salary.txt";
        try {
            File file = new File("Salary.txt"); // Use local file if available
            Scanner scanner = new Scanner(file);

            double assistantTotal = 0;
            double associateTotal = 0;
            double fullTotal = 0;
            int assistantCount = 0;
            int associateCount = 0;
            int fullCount = 0;

            while (scanner.hasNext()) {
                String firstName = scanner.next();
                String lastName = scanner.next();
                String rank = scanner.next();
                double salary = scanner.nextDouble();

                switch (rank) {
                    case "assistant":
                        assistantTotal += salary;
                        assistantCount++;
                        break;
                    case "associate":
                        associateTotal += salary;
                        associateCount++;
                        break;
                    case "full":
                        fullTotal += salary;
                        fullCount++;
                        break;
                }
            }

            scanner.close();

            double allTotal = assistantTotal + associateTotal + fullTotal;
            int allCount = assistantCount + associateCount + fullCount;

            System.out.println("Total salary for assistant professors: " + String.format("%.2f", assistantTotal));
            System.out.println("Total salary for associate professors: " + String.format("%.2f", associateTotal));
            System.out.println("Total salary for full professors: " + String.format("%.2f", fullTotal));
            System.out.println("Total salary for all faculty: " + String.format("%.2f", allTotal));

            System.out.println("Average salary for assistant professors: " + String.format("%.2f", assistantTotal / assistantCount));
            System.out.println("Average salary for associate professors: " + String.format("%.2f", associateTotal / associateCount));
            System.out.println("Average salary for full professors: " + String.format("%.2f", fullTotal / fullCount));
            System.out.println("Average salary for all faculty: " + String.format("%.2f", allTotal / allCount));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: Salary.txt");
        }
    }
}
