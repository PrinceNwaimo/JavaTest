package liangBinarySearchTree;
import java.util.*;

public class BST4 <E extends Comparable<E>> {
    private TreeNode<E> root;

    // Insert a new element into the BST
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
            } else {
                parent.right = new TreeNode<>(e);
            }
        }
        return true;
    }

    /** Non-recursive postorder traversal using a stack */
    public void postorder() {
        if (root == null) return;

        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> current = root;
        TreeNode<E> lastVisited = null;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode<E> peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    System.out.print(peekNode.element + " ");
                    lastVisited = stack.pop();
                }
            }
        }
    }

    /** Tree node inner class */
    private static class TreeNode<E> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }
    /** Returns the number of leaf nodes */
    public int getNumberOfLeaves() {
        return getNumberOfLeaves(root);
    }

    private int getNumberOfLeaves(TreeNode<E> node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            return 1; // This is a leaf
        }

        // Sum leaves in left and right subtrees
        return getNumberOfLeaves(node.left) + getNumberOfLeaves(node.right);
    }
    /** Returns the number of nonleaf nodes */
    public int getNumberOfNonLeaves() {
        return getNumberOfNonLeaves(root);
    }

    private int getNumberOfNonLeaves(TreeNode<E> node) {
        if (node == null) return 0;

        // Leaf node → not counted as non-leaf
        if (node.left == null && node.right == null) {
            return 0;
        }

        // Count this node + recurse on children
        return 1 + getNumberOfNonLeaves(node.left) + getNumberOfNonLeaves(node.right);
    }
    public ListIterator<E> bidirectionalIterator() {
        return new InorderBidirectionalIterator();
    }

    /** Inner class for bidirectional inorder iterator */
    private class InorderBidirectionalIterator implements ListIterator<E> {
        private ArrayList<E> elements = new ArrayList<>();
        private int current = 0;  // cursor position

        public InorderBidirectionalIterator() {
            inorder(root);
        }

        private void inorder(TreeNode<E> node) {
            if (node == null) return;
            inorder(node.left);
            elements.add(node.element);
            inorder(node.right);
        }

        @Override
        public boolean hasNext() {
            return current < elements.size();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return elements.get(current++);
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            return elements.get(--current);
        }

        @Override
        public int nextIndex() {
            return current;
        }

        @Override
        public int previousIndex() {
            return current - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException("Set not supported");
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("Add not supported");
        }
    }

    /** TreeNode inner class */
    public static class TreeNode2<T> {
        public T element;
        public TreeNode2<T> left;
        public TreeNode2<T> right;
        public TreeNode2(T e) {
            element = e;
        }
    }
    public Iterator<E> preorderIterator() {
        return new PreorderIterator();
    }

    private class PreorderIterator implements Iterator<E> {
        private Stack<TreeNode<E>> stack = new Stack<>();

        public PreorderIterator() {
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            TreeNode<E> current = stack.pop();
            // Push right first so that left is processed first (LIFO)
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
            return current.element;
        }

        @Override
        public void remove() {
            // Optional - You can implement deletion logic if needed.
            throw new UnsupportedOperationException("Remove not supported in preorder iterator");
        }
    }

}

