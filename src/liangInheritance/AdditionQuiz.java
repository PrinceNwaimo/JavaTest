package liangInheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class AdditionQuiz {
    public static void main(String[] args) {
        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);
        int correctAnswer = num1 + num2;
        ArrayList<Integer> answers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("What is " + num1 + " + " + num2 + "? ");
            int answer = scanner.nextInt();
            if (answers.contains(answer)) {
                System.out.println("You already entered " + answer);
            } else {
                answers.add(answer);
            }
            if (answer == correctAnswer) {
                System.out.println("You got it!");
                break;
            } else {
                System.out.println("Wrong answer. Try again.");
            }
        }
    }
}
