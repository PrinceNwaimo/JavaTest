package joyceTwoDimensionalArrays;

import java.util.Scanner;

public class DoesItHaveLegs {
    private static Node root;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        root = new Node("Does the animal you are thinking of have legs?");
        root.yes = new Node("dog");
        root.no = new Node("snake");

        while (true) {
            playGame();
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }
    }

    private static void playGame() {
        Node currentNode = root;
        while (true) {
            System.out.println(currentNode.question);
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("yes")) {
                if (currentNode.yes == null) {
                    System.out.println("Is it a " + currentNode.answer + "?");
                    response = scanner.nextLine().toLowerCase();
                    if (response.equals("yes")) {
                        System.out.println("Yay! I win.");
                        return;
                    } else {
                        System.out.println("I give up. What was your animal?");
                        String animal = scanner.nextLine();
                        System.out.println("Type a question for which the answer is Yes for " + currentNode.answer + " but No for " + animal);
                        String question = scanner.nextLine();
                        Node newNode = new Node(currentNode.answer);
                        currentNode.answer = null;
                        currentNode.question = question;
                        currentNode.yes = newNode;
                        currentNode.no = new Node(animal);
                        return;
                    }
                } else {
                    currentNode = currentNode.yes;
                }
            } else {
                if (currentNode.no == null) {
                    System.out.println("I give up. What was your animal?");
                    String animal = scanner.nextLine();
                    System.out.println("Type a question for which the answer is Yes for " + animal + " but No for " + currentNode.answer);
                    String question = scanner.nextLine();
                    Node newNode = new Node(animal);
                    currentNode.answer = null;
                    currentNode.question = question;
                    currentNode.no = newNode;
                    currentNode.yes = new Node(currentNode.answer);
                    return;
                } else {
                    currentNode = currentNode.no;
                }
            }
        }
    }

}
