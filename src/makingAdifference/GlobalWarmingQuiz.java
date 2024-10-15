package makingAdifference;

import java.util.Scanner;

public class GlobalWarmingQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Questions and options
        String[] questions = {
                "1. What is the primary greenhouse gas responsible for global warming?",
                "2. Which of the following is a potential consequence of global warming?",
                "3. What percentage of climate scientists agree that humans are causing global warming?",
                "4. What is one argument some people use to challenge the concept of man-made global warming?",
                "5. Which international agreement aims to reduce global greenhouse gas emissions?"
        };

        String[][] options = {
                {"1) Carbon dioxide", "2) Methane", "3) Nitrous oxide", "4) Water vapor"},
                {"1) Increase in global average temperature", "2) Decrease in sea levels", "3) Cooling of the Earth's core", "4) Increase in polar ice"},
                {"1) 50%", "2) 97%", "3) 60%", "4) 75%"},
                {"1) Natural climate variability", "2) Rising solar activity", "3) Earth's natural cooling mechanisms", "4) All of the above"},
                {"1) Kyoto Protocol", "2) Paris Agreement", "3) Copenhagen Accord", "4) Montreal Protocol"}
        };

        // Correct answers
        int[] correctAnswers = {1, 1, 2, 4, 2};

        // User's answers
        int[] userAnswers = new int[5];

        // Ask the questions
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Your answer (1-4): ");
            userAnswers[i] = input.nextInt();

            // Validate input
            while (userAnswers[i] < 1 || userAnswers[i] > 4) {
                System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
                userAnswers[i] = input.nextInt();
            }
        }

        // Calculate the score
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i] == correctAnswers[i]) {
                score++;
            }
        }

        // Display the result
        System.out.printf("%nYou scored %d out of 5.%n", score);

        // Provide feedback based on the score
        if (score == 5) {
            System.out.println("Excellent");
        } else if (score == 4) {
            System.out.println("Very good");
        } else {
            System.out.println("Time to brush up on your knowledge of global warming.");
            System.out.println("Here are some websites where you can learn more:");
            System.out.println("1) https://climate.nasa.gov/");
            System.out.println("2) https://www.ipcc.ch/");
            System.out.println("3) https://www.epa.gov/climatechange");
            System.out.println("4) https://www.globalchange.gov/");
        }

        input.close();
    }
}
