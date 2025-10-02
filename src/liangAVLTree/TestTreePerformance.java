package liangAVLTree;

import liangBinarySearchTree.BST;
import java.util.*;

public class TestTreePerformance {
    public static void main(String[] args) {
        int N = 500_000;
        Integer[] numbers = new Integer[N];
        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            numbers[i] = rand.nextInt(N * 10); // generate large range
        }

        // ================= Test BST =================
        BST<Integer> bst = new BST<>();

        // Insert
        long start = System.currentTimeMillis();
        for (int num : numbers) {
            bst.insert(num);
        }
        long end = System.currentTimeMillis();
        System.out.println("BST insertion time: " + (end - start) + " ms");

        // Search
        Collections.shuffle(Arrays.asList(numbers));
        start = System.currentTimeMillis();
        for (int num : numbers) {
            bst.search(num);
        }
        end = System.currentTimeMillis();
        System.out.println("BST search time: " + (end - start) + " ms");

        // Delete
        Collections.shuffle(Arrays.asList(numbers));
        start = System.currentTimeMillis();
        for (int num : numbers) {
            bst.delete(num);
        }
        end = System.currentTimeMillis();
        System.out.println("BST deletion time: " + (end - start) + " ms");

        // ================= Test AVLTree =================
        AVLTree<Integer> avl = new AVLTree<>();

        // Insert
        start = System.currentTimeMillis();
        for (int num : numbers) {
            avl.insert(num);
        }
        end = System.currentTimeMillis();
        System.out.println("AVL insertion time: " + (end - start) + " ms");

        // Search
        Collections.shuffle(Arrays.asList(numbers));
        start = System.currentTimeMillis();
        for (int num : numbers) {
            avl.search(num);
        }
        end = System.currentTimeMillis();
        System.out.println("AVL search time: " + (end - start) + " ms");

        // Delete
        Collections.shuffle(Arrays.asList(numbers));
        start = System.currentTimeMillis();
        for (int num : numbers) {
            avl.delete(num);
        }
        end = System.currentTimeMillis();
        System.out.println("AVL deletion time: " + (end - start) + " ms");
    }
}

