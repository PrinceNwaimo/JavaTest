package joyceArrays;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
                "What is the most popular sport?",
                "Which planet is known as the Red Planet?",
                "Who painted the Starry Night?",
                "What is the chemical symbol for gold?",
                "Who wrote Romeo and Juliet?",
                "What is the largest mammal?",
                "Who was the first president of the United States?",
                "What is the smallest country in the world?",
                "Who wrote To Kill a Mockingbird?",
                "What is the largest planet in our solar system?"
        };

        String[][] options = {
                {"A) Football", "B) Basketball", "C) Soccer"},
                {"A) Earth", "B) Mars", "C) Jupiter"},
                {"A) Leonardo da Vinci", "B) Vincent van Gogh", "C) Pablo Picasso"},
                {"A) Ag", "B) Au", "C) Pb"},
                {"A) William Shakespeare", "B) Jane Austen", "C) Charles Dickens"},
                {"A) Elephant", "B) Blue whale", "C) Lion"},
                {"A) George Washington", "B) Thomas Jefferson", "C) Abraham Lincoln"},
                {"A) Vatican City", "B) Monaco", "C) San Marino"},
                {"A) F. Scott Fitzgerald", "B) Harper Lee", "C) Jane Austen"},
                {"A) Earth", "B) Saturn", "C) Jupiter"}
        };

        char[] correctAnswers = {'C', 'B', 'B', 'B', 'A', 'B', 'A', 'A', 'B', 'C'};

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            char answer;
            while (true) {
                System.out.print("Enter your answer (A, B, or C): ");
                String input = scanner.next().trim().toUpperCase();
                if (input.length() == 1 && input.matches("[ABC]")) {
                    answer = input.charAt(0);
                    break;
                }
                System.out.println("Invalid input. Please enter A, B, or C.");
            }

            if (answer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("The correct answer is " + correctAnswers[i]);
            }
        }

        System.out.println("\nQuiz results:");
        System.out.println("Correct answers: " + score);
        System.out.println("Incorrect answers: " + (questions.length - score));

        scanner.close();
    }

}
