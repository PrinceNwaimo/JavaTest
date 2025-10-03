package liangBinarySearchTree;
import java.util.ArrayList;
import java.util.Scanner;

public class BST6<E extends Comparable<E>> {
        protected TreeNode<E> root;
        protected int size = 0;

        /** Create a default BST */
        public BST6() {
        }

        /** Insert element into the BST. Return true if successful. */
        public boolean insert(E e) {
            if (root == null) {
                root = new TreeNode<>(e);
            } else {
                TreeNode<E> parent = null;
                TreeNode<E> current = root;
                while (current != null) {
                    if (e.compareTo(current.element) < 0) {
                        parent = current;
                        current = current.left;
                    } else if (e.compareTo(current.element) > 0) {
                        parent = current;
                        current = current.right;
                    } else {
                        return false; // Duplicate node not inserted
                    }
                }

                if (e.compareTo(parent.element) < 0) {
                    parent.left = new TreeNode<>(e);
                    parent.left.parent = parent; // set parent reference
                } else {
                    parent.right = new TreeNode<>(e);
                    parent.right.parent = parent; // set parent reference
                }
            }

            size++;
            return true;
        }

        /** Delete an element from the BST. Return true if successful. */
        public boolean delete(E e) {
            // Locate the node to be deleted and its parent
            TreeNode<E> current = root;
            TreeNode<E> parent = null;

            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    break; // Element is in the tree pointed by current
                }
            }

            if (current == null) {
                return false; // Element not in the tree
            }

            // Case 1: current has no left child
            if (current.left == null) {
                if (parent == null) {
                    root = current.right;
                    if (root != null) root.parent = null;
                } else {
                    if (e.compareTo(parent.element) < 0) {
                        parent.left = current.right;
                        if (parent.left != null) parent.left.parent = parent;
                    } else {
                        parent.right = current.right;
                        if (parent.right != null) parent.right.parent = parent;
                    }
                }
            }
            // Case 2: current has a left child
            else {
                // Locate the rightmost node in the left subtree
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right;
                }

                // Replace current's element with rightMost's element
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost) {
                    parentOfRightMost.right = rightMost.left;
                    if (rightMost.left != null) rightMost.left.parent = parentOfRightMost;
                } else {
                    parentOfRightMost.left = rightMost.left;
                    if (rightMost.left != null) rightMost.left.parent = parentOfRightMost;
                }
            }

            size--;
            return true;
        }

        /** Returns the node for the specified element. Returns null if not found */
        private TreeNode<E> getNode(E element) {
            TreeNode<E> current = root;
            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    current = current.right;
                } else {
                    return current;
                }
            }
            return null;
        }

        /** Returns true if the node for the element is a leaf */
        private boolean isLeaf(E element) {
            TreeNode<E> node = getNode(element);
            return node != null && node.left == null && node.right == null;
        }

        /** Returns the path of elements from the specified element to the root */
        public ArrayList<E> getPath(E e) {
            ArrayList<E> path = new ArrayList<>();
            TreeNode<E> node = getNode(e);
            while (node != null) {
                path.add(node.element);
                node = node.parent;
            }
            return path;
        }

        /** Returns the number of nodes in the tree */
        public int getSize() {
            return size;
        }

        /** Returns all leaf nodes in the tree */
        public ArrayList<E> getAllLeaves() {
            ArrayList<E> leaves = new ArrayList<>();
            collectLeaves(root, leaves);
            return leaves;
        }

        private void collectLeaves(TreeNode<E> node, ArrayList<E> leaves) {
            if (node == null) return;
            if (node.left == null && node.right == null) {
                leaves.add(node.element);
            } else {
                collectLeaves(node.left, leaves);
                collectLeaves(node.right, leaves);
            }
        }

        /** TreeNode class with parent reference */
        public static class TreeNode<E> {
            E element;
            TreeNode<E> left;
            TreeNode<E> right;
            TreeNode<E> parent;

            public TreeNode(E e) {
                element = e;
            }
        }
    }


