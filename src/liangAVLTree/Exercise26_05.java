package liangAVLTree;

import java.util.Scanner;

public class Exercise26_05 {
    public static void main(String[] args) {
        AVLTree<Double> tree = new AVLTree<>();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 15 numbers: ");
        for (int i = 0; i < 15; i++) {
            tree.insert(input.nextDouble());
        }

        System.out.print("Enter k: ");
        int k = input.nextInt();

        Double result = tree.find(k);
        if (result == null) {
            System.out.println("Invalid k (must be between 1 and tree size)");
        } else {
            System.out.println("The " + k + "th smallest number is " + result);
        }
    }
}
