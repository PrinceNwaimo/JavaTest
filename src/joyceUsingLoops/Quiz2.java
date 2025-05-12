package joyceUsingLoops;

import java.util.Scanner;

public class Quiz2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
                "What is the most popular music genre in the world?",
                "Which planet in our solar system is known for being the largest?",
                "Who painted the famous painting 'The Starry Night'?",
                "What is the chemical symbol for gold?",
                "Which musician is known for playing the guitar with his teeth?"
        };

        String[][] options = {
                {"Rock", "Pop", "Hip-Hop", "Classical"},
                {"Earth", "Saturn", "Jupiter", "Uranus"},
                {"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"},
                {"Ag", "Au", "Hg", "Pb"},
                {"Jimi Hendrix", "Eric Clapton", "Jimmy Page", "Stevie Ray Vaughan"}
        };

        String[] answers = {"Rock", "Jupiter", "Vincent van Gogh", "Au", "Jimi Hendrix"};

        for (int i = 0; i < questions.length; i++) {
            boolean correct = false;
            while (!correct) {
                System.out.println(questions[i]);
                for (int j = 0; j < options[i].length; j++) {
                    System.out.println((j + 1) + ". " + options[i][j]);
                }
                System.out.print("Enter the number of your answer: ");
                int userAnswer = scanner.nextInt();
                String userAnswerString = options[i][userAnswer - 1];

                if (userAnswerString.equals(answers[i])) {
                    System.out.println("Congratulations! Your answer is correct.");
                    correct = true;
                } else {
                    System.out.println("Sorry, your answer is incorrect. The correct answer is " + answers[i] + ". Try again.");
                }
            }
        }

        System.out.println("Congratulations! You have answered all questions correctly.");

        scanner.close();
    }

}

