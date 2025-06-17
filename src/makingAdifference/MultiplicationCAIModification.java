package makingAdifference;

import java.security.SecureRandom;
import java.util.Scanner;

public class MultiplicationCAIModification {
    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            askQuestion();
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
                break;
            } else {
                System.out.println(getIncorrectResponse());
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

}
