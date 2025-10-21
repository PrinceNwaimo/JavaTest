package diettelGenericDataStructures;

import java.util.Scanner;
import java.util.Stack;

public class DescendingOrderPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter 6 numbers in ascending order:");
        for (int i = 0; i < 6; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            int number = scanner.nextInt();
            stack.push(number);
        }

        System.out.println("\nNumbers in descending order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
