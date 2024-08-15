package chapterThree;
import java.util.Scanner;

public class ScissorRockPaper {
        public static void main(String[] args) {
            int computerChoice = (int) (Math.random() * 3);
            Scanner input = new Scanner(System.in);
            System.out.print("scissor (0), rock (1), paper (2): ");
            int userChoice = input.nextInt();
            System.out.print("The computer is " + choiceToString(computerChoice) + ". ");
            System.out.print("You are " + choiceToString(userChoice) + ". ");
            if (computerChoice == userChoice) {
                System.out.println("It is a draw.");
            } else if ((userChoice == 0 && computerChoice == 2) ||
                    (userChoice == 1 && computerChoice == 0) ||
                    (userChoice == 2 && computerChoice == 1)) {
                System.out.println("You won.");
            } else {
                System.out.println("You lost.");
            }
        }

        public static String choiceToString(int choice) {
            switch (choice) {
                case 0: return "scissor";
                case 1: return "rock";
                case 2: return "paper";
                default: return "Invalid choice";
            }
        }
    }


