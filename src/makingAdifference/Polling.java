package makingAdifference;

import java.util.Scanner;

public class Polling {
    public static void main(String[] args) {
        String[] topics = {"Climate Change", "Gun Control", "Immigration Reform", "Healthcare Reform", "Economic Inequality"};
        int[][] responses = new int[topics.length][10];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < topics.length; i++) {
            System.out.println("Rate the importance of " + topics[i] + " from 1 (least important) to 10 (most important):");
            for (int j = 0; j < 10; j++) {
                responses[i][j] = 0;
            }
            while (true) {
                System.out.print("Enter your rating (1-10): ");
                int rating = scanner.nextInt();
                if (rating >= 1 && rating <= 10) {
                    responses[i][rating - 1]++;
                    break;
                } else {
                    System.out.println("Invalid rating. Please try again.");
                }
            }
        }

        System.out.println("Tabular Report:");
        System.out.print("Topic\t");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "\t");
        }
        System.out.println("Average");

        for (int i = 0; i < topics.length; i++) {
            System.out.print(topics[i] + "\t");
            int sum = 0;
            int count = 0;
            for (int j = 0; j < 10; j++) {
                System.out.print(responses[i][j] + "\t");
                sum += (j + 1) * responses[i][j];
                count += responses[i][j];
            }
            double average = (double) sum / count;
            System.out.println(average);
        }

        int maxPoints = 0;
        String maxTopic = "";
        for (int i = 0; i < topics.length; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += (j + 1) * responses[i][j];
            }
            if (sum > maxPoints) {
                maxPoints = sum;
                maxTopic = topics[i];
            }
        }
        System.out.println("Issue with highest point total: " + maxTopic + " with " + maxPoints + " points");
        int minPoints = Integer.MAX_VALUE;
        String minTopic = "";
        for (int i = 0; i < topics.length; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += (j + 1) * responses[i][j];
            }
            if (sum < minPoints) {
                minPoints = sum;
                minTopic = topics[i];
            }
        }
        System.out.println("Issue with lowest point total: " + minTopic + " with " + minPoints + " points");
    }

}
