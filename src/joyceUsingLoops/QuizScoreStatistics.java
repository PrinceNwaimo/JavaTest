package joyceUsingLoops;

import java.util.Scanner;

public class QuizScoreStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        double sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        while (true) {
            System.out.print("Enter a quiz score (0-10) or 99 to finish: ");
            int score = scanner.nextInt();

            if (score == 99) {
                break;
            }

            if (score < 0 || score > 10) {
                System.out.println("Invalid score. Please enter a score between 0 and 10.");
                continue;
            }

            count++;
            sum += score;

            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }

        scanner.close();

        if (count == 0) {
            System.out.println("No scores entered.");
        } else {
            double average = sum / count;
            System.out.println("Number of scores: " + count);
            System.out.println("Highest score: " + highest);
            System.out.println("Lowest score: " + lowest);
            System.out.println("Average score: " + average);
        }
    }

}
