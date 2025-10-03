package liangAVLTree;
import liangAVLTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AVLTree2<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void insert(E e) {
        root = insert(root, e, null);
    }

    private TreeNode<E> insert(TreeNode<E> node, E e, TreeNode<E> parent) {
        if (node == null) {
            return new TreeNode<>(e, parent);
        }

        if (e.compareTo(node.element) < 0) {
            node.left = insert(node.left, e, node);
        } else if (e.compareTo(node.element) > 0) {
            node.right = insert(node.right, e, node);
        } else {
            return node; // duplicate not allowed
        }

        updateHeight(node);
        return balance(node);
    }

    private void updateHeight(TreeNode<E> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(TreeNode<E> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(TreeNode<E> node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Perform rotations
    private TreeNode<E> balance(TreeNode<E> node) {
        int balance = getBalance(node);

        // Left heavy
        if (balance > 1) {
            if (getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        // Right heavy
        if (balance < -1) {
            if (getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private TreeNode<E> rotateRight(TreeNode<E> y) {
        TreeNode<E> x = y.left;
        TreeNode<E> T2 = x.right;

        x.right = y;
        y.left = T2;

        if (T2 != null) T2.parent = y;
        x.parent = y.parent;
        y.parent = x;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private TreeNode<E> rotateLeft(TreeNode<E> x) {
        TreeNode<E> y = x.right;
        TreeNode<E> T2 = y.left;

        y.left = x;
        x.right = T2;

        if (T2 != null) T2.parent = x;
        y.parent = x.parent;
        x.parent = y;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // Display paths for all leaf nodes
    public void printLeafPaths() {
        printLeafPaths(root);
    }

    private void printLeafPaths(TreeNode<E> node) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            printPath(node);
        }

        printLeafPaths(node.left);
        printLeafPaths(node.right);
    }

    private void printPath(TreeNode<E> leaf) {
        List<E> path = new ArrayList<>();
        TreeNode<E> current = leaf;
        while (current != null) {
            path.add(current.element);
            current = current.parent;
        }
        Collections.reverse(path);
        System.out.println(path);
    }
}
