package liangBinarySearchTree;

import java.util.Iterator;

public class TestPreorderIterator {
        public static void main(String[] args) {
            BST4<Integer> tree = new BST4<>();
            tree.insert(50);
            tree.insert(30);
            tree.insert(70);
            tree.insert(20);
            tree.insert(40);
            tree.insert(60);
            tree.insert(80);

            System.out.println("Preorder traversal using iterator:");
            Iterator<Integer> it = tree.preorderIterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();
        }
    }


