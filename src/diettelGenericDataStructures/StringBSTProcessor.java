package diettelGenericDataStructures;

import java.util.Scanner;

public class StringBSTProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        String[] words = input.split("\\s+"); // Tokenize by whitespace
        BinarySearchTree bst = new BinarySearchTree();

        for (String word : words) {
            // Basic cleanup (optional): word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                bst.insert(word);
            }
        }

        bst.inorderTraversal();
        bst.preorderTraversal();
        bst.postorderTraversal();
    }
}
