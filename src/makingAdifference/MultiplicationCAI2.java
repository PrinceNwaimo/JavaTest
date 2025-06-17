package makingAdifference;

import java.security.SecureRandom;
import java.util.Scanner;

public class MultiplicationCAI2 {
    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);
    private static int correctCount = 0;
    private static int incorrectCount = 0;

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                askQuestion();
            }
            calculatePerformance();
            reset();
        }
    }

    public static void askQuestion() {
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);

        while (true) {
            System.out.printf("How much is %d times %d?%n", num1, num2);
            int answer = scanner.nextInt();

            if (answer == num1 * num2) {
                System.out.println(getCorrectResponse());
                correctCount++;
                break;
            } else {
                System.out.println(getIncorrectResponse());
                incorrectCount++;
            }
        }
    }

    public static String getCorrectResponse() {
        int response = random.nextInt(4) + 1;
        switch (response) {
            case 1:
                return "Very good!";
            case 2:
                return "Excellent!";
            case 3:
                return "Nice work!";
            case 4:
                return "Keep up the good work!";
            default:
                return "";
        }
    }

    public static String getIncorrectResponse() {
        int response = random.nextInt(4) + 1;
        switch (response) {
            case 1:
                return "No. Please try again.";
            case 2:
                return "Wrong. Try once more.";
            case 3:
                return "Don't give up!";
            case 4:
                return "No. Keep trying.";
            default:
                return "";
        }
    }

    public static void calculatePerformance() {
        double percentage = ((double) correctCount / (correctCount + incorrectCount)) * 100;
        System.out.printf("You answered %d questions correctly and %d questions incorrectly.%n", correctCount, incorrectCount);
        System.out.printf("Your percentage is %.2f%%%n", percentage);

        if (percentage >= 75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
        } else {
            System.out.println("Please ask your teacher for extra help.");
        }
    }

    public static void reset() {
        correctCount = 0;
        incorrectCount = 0;
        System.out.println("Let's start a new session.");
        System.out.println();
    }

}
