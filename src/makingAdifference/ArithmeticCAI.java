package makingAdifference;

import java.security.SecureRandom;
import java.util.Scanner;

public class ArithmeticCAI {
    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);
    private static int correctCount = 0;
    private static int incorrectCount = 0;

    public static void main(String[] args) {
        System.out.print("Enter a difficulty level (1-4): ");
        int difficultyLevel = scanner.nextInt();
        int maxNumber = (int) Math.pow(10, difficultyLevel);

        System.out.println("Choose a type of arithmetic problem to study:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Random mixture");
        System.out.print("Enter your choice (1-5): ");
        int problemType = scanner.nextInt();

        while (true) {
            for (int i = 0; i < 10; i++) {
                askQuestion(maxNumber, problemType);
            }
            calculatePerformance();
            reset();
        }
    }

    public static void askQuestion(int maxNumber, int problemType) {
        int num1 = random.nextInt(maxNumber);
        int num2 = random.nextInt(maxNumber);

        switch (problemType) {
            case 1:
                askAdditionQuestion(num1, num2);
                break;
            case 2:
                askSubtractionQuestion(num1, num2);
                break;
            case 3:
                askMultiplicationQuestion(num1, num2);
                break;
            case 4:
                askDivisionQuestion(num1, num2);
                break;
            case 5:
                askRandomQuestion(num1, num2);
                break;
        }
    }

    public static void askAdditionQuestion(int num1, int num2) {
        int answer = num1 + num2;
        checkAnswer(num1, num2, answer, "+");
    }

    public static void askSubtractionQuestion(int num1, int num2) {
        int answer = num1 - num2;
        checkAnswer(num1, num2, answer, "-");
    }

    public static void askMultiplicationQuestion(int num1, int num2) {
        int answer = num1 * num2;
        checkAnswer(num1, num2, answer, "*");
    }

    public static void askDivisionQuestion(int num1, int num2) {
        if (num2 == 0) {
            num2 = 1;
        }
        int answer = num1 / num2;
        checkAnswer(num1, num2, answer, "/");
    }

    public static void askRandomQuestion(int num1, int num2) {
        int problemType = random.nextInt(4) + 1;
        switch (problemType) {
            case 1:
                askAdditionQuestion(num1, num2);
                break;
            case 2:
                askSubtractionQuestion(num1, num2);
                break;
            case 3:
                askMultiplicationQuestion(num1, num2);
                break;
            case 4:
                askDivisionQuestion(num1, num2);
                break;
        }
    }

    public static void checkAnswer(int num1, int num2, int answer, String operator) {
        while (true) {
            System.out.printf("How much is %d %s %d?%n", num1, operator, num2);
            int userAnswer = scanner.nextInt();

            if (userAnswer == answer) {
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
            System.out.println("Congratulations, you are doing great!");
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
