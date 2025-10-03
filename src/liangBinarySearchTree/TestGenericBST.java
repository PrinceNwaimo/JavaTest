package liangBinarySearchTree;
import java.util.Comparator;

public class TestGenericBST {
        public static void main(String[] args) {
            // Example 1: Natural ordering (Integer)
            BST<Integer> tree1 = new BST<>();
            tree1.insert(50);
            tree1.insert(30);
            tree1.insert(70);
            tree1.insert(10);
            tree1.insert(90);

            System.out.print("Inorder with natural ordering: ");
            tree1.inorder();  // Output: 10 30 50 70 90
            System.out.println();

            // Example 2: Custom comparator (reverse order)
            Comparator<Integer> reverseComparator = (a, b) -> b - a;
            BST5<Integer> tree2 = new BST5<>(reverseComparator);
            tree2.insert(50);
            tree2.insert(30);
            tree2.insert(70);
            tree2.insert(10);
            tree2.insert(90);

            System.out.print("Inorder with reverse ordering: ");
            tree2.inorder();  // Output: 90 70 50 30 10
        }
    }


