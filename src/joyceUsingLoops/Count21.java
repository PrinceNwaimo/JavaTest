package joyceUsingLoops;

import java.util.Scanner;

public class Count21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;

        while (true) {
            // Player's turn
            int playerInput;
            while (true) {
                System.out.print("Enter 1, 2, or 3: ");
                playerInput = scanner.nextInt();
                if (playerInput >= 1 && playerInput <= 3) {
                    break;
                }
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }

            total += playerInput;
            System.out.println("You entered: " + playerInput + ". Total: " + total);

            if (total >= 21) {
                System.out.println("You lose!");
                break;
            }

            // Computer's turn
            int computerInput = 4 - playerInput;
            total += computerInput;
            System.out.println("Computer entered: " + computerInput + ". Total: " + total);

            if (total >= 21) {
                System.out.println("Computer loses! You win!");
                break;
            }
        }

        scanner.close();
    }

}
