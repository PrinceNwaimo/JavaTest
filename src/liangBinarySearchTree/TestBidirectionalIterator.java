package liangBinarySearchTree;

import java.util.ListIterator;

public class TestBidirectionalIterator{
        public static void main(String[] args) {
            BST4<Integer> tree = new BST4<>();
            int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
            for (int v : values) {
                tree.insert(v);
            }

            ListIterator<Integer> iterator = tree.bidirectionalIterator();

            System.out.println("Forward traversal:");
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }

            System.out.println("\nBackward traversal:");
            while (iterator.hasPrevious()) {
                System.out.print(iterator.previous() + " ");
            }
        }
    }


