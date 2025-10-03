package liangBinarySearchTree;
import java.util.Comparator;
public class BST5<E> {

        protected TreeNode<E> root;
        protected int size = 0;
        protected Comparator<? super E> comparator;

        /** Create a default BST with natural ordering */
        public BST5() {
            this.comparator = null;
        }

        /** Create a BST with a custom comparator */
        public BST5(Comparator<? super E> comparator) {
            this.comparator = comparator;
        }

        /** Create a BST from an array of objects */
        public BST5(E[] objects) {
            for (E obj : objects) {
                insert(obj);
            }
        }

        /** Insert element into the BST. Return true if successful. */
        public boolean insert(E e) {
            if (root == null) {
                root = createNewNode(e); // Create a new root
            } else {
                TreeNode<E> parent = null;
                TreeNode<E> current = root;
                while (current != null) {
                    if (compare(e, current.element) < 0) {
                        parent = current;
                        current = current.left;
                    } else if (compare(e, current.element) > 0) {
                        parent = current;
                        current = current.right;
                    } else {
                        return false; // Duplicate node not inserted
                    }
                }

                // Create the new node and attach it to the parent node
                if (compare(e, parent.element) < 0) {
                    parent.left = createNewNode(e);
                } else {
                    parent.right = createNewNode(e);
                }
            }

            size++;
            return true;
        }

        /** A utility method to compare elements using either comparator or natural order */
        private int compare(E e1, E e2) {
            if (comparator == null) {
                return ((Comparable<E>) e1).compareTo(e2);
            } else {
                return comparator.compare(e1, e2);
            }
        }

        /** Create a new TreeNode */
        protected TreeNode<E> createNewNode(E e) {
            return new TreeNode<>(e);
        }

        /** Inorder traversal */
        public void inorder() {
            inorder(root);
        }

        protected void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }

        /** Get the number of nodes in the tree */
        public int getSize() {
            return size;
        }

        /** TreeNode class */
        public static class TreeNode<E> {
            protected E element;
            protected TreeNode<E> left;
            protected TreeNode<E> right;

            public TreeNode(E e) {
                element = e;
            }
        }
    }


