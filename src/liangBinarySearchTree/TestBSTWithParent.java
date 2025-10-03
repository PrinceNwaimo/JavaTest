package liangBinarySearchTree;
import java.util.ArrayList;
import java.util.Scanner;

public class TestBSTWithParent {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            BST6<Integer> tree = new BST6<>();

            // Read 10 integers
            System.out.print("Enter 10 integers: ");
            int[] numbers = new int[10];
            for (int i = 0; i < 10; i++) {
                numbers[i] = input.nextInt();
                tree.insert(numbers[i]);
            }

            // Delete the first integer
            System.out.println("Deleting " + numbers[0]);
            tree.delete(numbers[0]);

            // Display the paths for all leaf nodes
            ArrayList<Integer> leaves = tree.getAllLeaves();
            System.out.println("Paths for all leaf nodes:");
            for (int leaf : leaves) {
                ArrayList<Integer> path = tree.getPath(leaf);
                System.out.print("Path for leaf " + leaf + ": ");
                for (int value : path) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }


