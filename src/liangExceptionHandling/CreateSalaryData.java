package liangExceptionHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateSalaryData {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Salary.txt");
            Random random = new Random();

            for (int i = 1; i <= 1000; i++) {
                String rank = getRandomRank(random);
                double salary = getRandomSalary(rank, random);
                writer.write("FirstName" + i + " LastName" + i + " " + rank + " " + String.format("%.2f", salary) + "\n");
            }

            writer.close();
            System.out.println("Data generated and saved to Salary.txt");
        } catch (IOException e) {
            System.out.println("Error generating data: " + e.getMessage());
        }
    }

    private static String getRandomRank(Random random) {
        String[] ranks = {"assistant", "associate", "full"};
        return ranks[random.nextInt(3)];
    }

    private static double getRandomSalary(String rank, Random random) {
        double min = 0;
        double max = 0;

        switch (rank) {
            case "assistant":
                min = 50000;
                max = 80000;
                break;
            case "associate":
                min = 60000;
                max = 110000;
                break;
            case "full":
                min = 75000;
                max = 130000;
                break;
        }

        return min + (max - min) * random.nextDouble();
    }
}
