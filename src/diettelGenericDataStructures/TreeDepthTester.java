package diettelGenericDataStructures;

import java.util.Random;

public class TreeDepthTester {
    public static void main(String[] args) {
        BinarySearchTree2 bst = new BinarySearchTree2();
        Random random = new Random();

        System.out.println("Inserting 20 random integers into the BST:");
        for (int i = 0; i < 20; i++) {
            int randomInt = random.nextInt(100); // 0 to 99
            System.out.print(randomInt + " ");
            bst.insert(randomInt);
        }
        System.out.println("\n");

        bst.inorderTraversal();
        int depth = bst.getDepth();
        System.out.println("Depth of the binary tree: " + depth);
    }
}
