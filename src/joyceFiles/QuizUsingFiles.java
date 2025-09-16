package joyceFiles;

import java.io.*;
import java.util.Scanner;

public class QuizUsingFiles {
    public static void main(String[] args) {
        int highScore = readHighScore();
        System.out.println("High score: " + highScore);

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        String[] questions = {"What is the capital of France?", "What is the largest planet in our solar system?", "When did Nigeria gain her independence?", "What is the capital of Abia State?"};
        String[][] options = {{"Berlin", "Paris", "London", "Rome"}, {"Earth", "Saturn", "Jupiter", "Uranus"}, {"1959" ,"1960","1963"}, {"Aba", "Umuahia","Owerri","Awka"}};
        String[] answers = {"Paris", "Jupiter","1960", "Umuahia"};

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }
            System.out.print("Enter your answer (1-4): ");
            int response = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            if (options[i][response - 1].equals(answers[i])) {
                score++;
            }
        }

        System.out.println("Your score: " + score);
        if (score > highScore) {
            writeHighScore(score);
            System.out.println("New high score!");
        }
    }

    private static int readHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            return 0;
        }
    }

    private static void writeHighScore(int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt"))) {
            writer.write(String.valueOf(score));
        } catch (IOException e) {
            System.out.println("Error writing high score.");
        }
    }
}

