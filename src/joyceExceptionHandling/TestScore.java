package joyceExceptionHandling;

import java.util.Scanner;

public class TestScore {
    public static void main(String[] args) {
        String[] studentIds = {"S001", "S002", "S003", "S004", "S005"};
        int[] scores = new int[studentIds.length];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < studentIds.length; i++) {
            try {
                System.out.print("Enter score for student " + studentIds[i] + ": ");
                int score = scanner.nextInt();
                if (score > 100) {
                    throw new ScoreException("Invalid score. Score should be less than or equal to 100.");
                }
                scores[i] = score;
            } catch (ScoreException e) {
                System.out.println(e.getMessage());
                scores[i] = 0;
            } catch (Exception e) {
                System.out.println("Invalid input. Score set to 0.");
                scanner.next(); // Clear invalid input
                scores[i] = 0;
            }
        }

        System.out.println("\nStudent IDs and Scores:");
        for (int i = 0; i < studentIds.length; i++) {
            System.out.println(studentIds[i] + ": " + scores[i]);
        }
    }
}
