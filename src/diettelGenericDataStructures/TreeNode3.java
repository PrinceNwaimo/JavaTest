package diettelGenericDataStructures;

import java.util.Scanner;

public class TreeNode3 {
    String data;
    TreeNode3 left;
    TreeNode3 right;

    public TreeNode3(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    TreeNode3 root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(String data) {
        root = insertRecursive(root, data);
    }

    private TreeNode3 insertRecursive(TreeNode3 root, String data) {
        if (root == null) {
            return new TreeNode3(data);
        }

        int compare = data.compareToIgnoreCase(root.data);
        if (compare < 0) {
            root.left = insertRecursive(root.left, data);
        } else if (compare > 0) {
            root.right = insertRecursive(root.right, data);
        }
        // Ignore duplicates (or adapt logic for handling)
        return root;
    }

    public void inorderTraversal() {
        System.out.println("Inorder Traversal:");
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(TreeNode3 root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    public void preorderTraversal() {
        System.out.println("Preorder Traversal:");
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(TreeNode3 root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void postorderTraversal() {
        System.out.println("Postorder Traversal:");
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(TreeNode3 root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }
}

