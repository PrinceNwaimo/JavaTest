package liangBinarySearchTree;

import java.util.Scanner;

// Test Program
public class TestPreorderWithoutRecursion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BST<Integer> tree = new BST<>();

        System.out.println("Enter 10 integers: ");
        for (int i = 0; i < 10; i++) {
            int num = input.nextInt();
            tree.insert(num);
        }

        System.out.println("Preorder traversal (non-recursive):");
        tree.preorder();
    }
}
