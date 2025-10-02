package liangBinarySearchTree;

import liangSortingAlgorithms.Heap;

import java.util.Scanner;

public class HuffmanCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        int[] counts = getCharacterFrequency(text); // Count frequency

        System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "Character", "Frequency", "Code");

        Tree tree = getHuffmanTree(counts); // Create a Huffman tree
        String[] codes = getCode(tree.root); // Get codes

        for (int i = 0; i < codes.length; i++) {
            if (counts[i] != 0) // (char)i is not in text if counts[i] is 0
                System.out.printf("%-15d%-15s%-15d%-15s\n", i, (char) i + "", counts[i], codes[i]);
        }
    }

    public static String[] getCode(Tree.Node root) {
        if (root == null) return null;
        String[] codes = new String[256];
        assignCode(root, codes);
        return codes;
    }

    /* Recursively assign codes to leaf nodes */
    private static void assignCode(Tree.Node root, String[] codes) {
        if (root.left != null) {
            root.left.code = root.code + "0";
            assignCode(root.left, codes);

            root.right.code = root.code + "1";
            assignCode(root.right, codes);
        } else {
            codes[(int) root.element] = root.code;
        }
    }

    /** Get a Huffman tree from the frequencies */
    public static Tree getHuffmanTree(int[] counts) {
        Heap<Tree> heap = new Heap<>(); // Use your Heap class

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                heap.add(new Tree(counts[i], (char) i)); // Create a leaf node
            }
        }

        while (heap.getSize() > 1) {
            Tree t1 = heap.remove(); // Smallest weight
            Tree t2 = heap.remove(); // Next smallest
            heap.add(new Tree(t1, t2)); // Merge trees
        }

        return heap.remove(); // Final Huffman tree
    }

    /** Count character frequencies */
    public static int[] getCharacterFrequency(String text) {
        int[] counts = new int[256]; // 256 ASCII characters
        for (int i = 0; i < text.length(); i++) {
            counts[(int) text.charAt(i)]++;
        }
        return counts;
    }

    /** Huffman coding tree */
    public static class Tree implements Comparable<Tree> {
        Node root;

        /** Create a tree merging two subtrees */
        public Tree(Tree t1, Tree t2) {
            root = new Node();
            root.left = t1.root;
            root.right = t2.root;
            root.weight = t1.root.weight + t2.root.weight;
        }

        /** Create a tree with a single leaf node */
        public Tree(int weight, char element) {
            root = new Node(weight, element);
        }

        @Override
        public int compareTo(Tree t) {
            return Integer.compare(this.root.weight, t.root.weight);
        }

        /** Node class */
        public static class Node {
            char element; // Stores the character for a leaf node
            int weight;   // weight of the subtree rooted at this node
            Node left;    // Reference to the left subtree
            Node right;   // Reference to the right subtree
            String code = ""; // Huffman code

            public Node() {
            }

            public Node(int weight, char element) {
                this.weight = weight;
                this.element = element;
            }
        }
    }
}
