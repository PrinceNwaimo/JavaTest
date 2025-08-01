package diettelArrays;

import java.util.Scanner;

public class TurtleGraphics2 {
    private static final int SIZE = 20;
    private static int[][] floor = new int[SIZE][SIZE];
    private static int row = 0;
    private static int col = 0;
    private static int direction = 0; // 0: right, 1: down, 2: left, 3: up
    private static boolean penDown = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String[] command = scanner.nextLine().split(",");
            switch (command[0].trim().toLowerCase()) {
                case "penup":
                case "1":
                    penUp();
                    break;
                case "pendown":
                case "2":
                    penDown();
                    break;
                case "turnright":
                case "3":
                    turnRight();
                    break;
                case "turnleft":
                case "4":
                    turnLeft();
                    break;
                case "move":
                case "5":
                    if (command.length > 1) {
                        move(Integer.parseInt(command[1].trim()));
                    } else {
                        System.out.println("Please specify the number of spaces to move.");
                    }
                    break;
                case "display":
                case "6":
                    displayFloor();
                    break;
                case "exit":
                case "9":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static void penUp() {
        penDown = false;
    }

    private static void penDown() {
        penDown = true;
    }

    private static void turnRight() {
        direction = (direction + 1) % 4;
    }

    private static void turnLeft() {
        direction = (direction + 3) % 4;
    }

    private static void move(int spaces) {
        for (int i = 0; i < spaces; i++) {
            switch (direction) {
                case 0: // right
                    if (col < SIZE - 1) {
                        col++;
                    } else {
                        System.out.println("Cannot move that way. Edge of floor reached.");
                        return;
                    }
                    break;
                case 1: // down
                    if (row < SIZE - 1) {
                        row++;
                    } else {
                        System.out.println("Cannot move that way. Edge of floor reached.");
                        return;
                    }
                    break;
                case 2: // left
                    if (col > 0) {
                        col--;
                    } else {
                        System.out.println("Cannot move that way. Edge of floor reached.");
                        return;
                    }
                    break;
                case 3: // up
                    if (row > 0) {
                        row--;
                    } else {
                        System.out.println("Cannot move that way. Edge of floor reached.");
                        return;
                    }
                    break;
            }
            if (penDown) {
                floor[row][col] = 1;
            }
        }
    }

    private static void displayFloor() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (floor[i][j] == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

}
