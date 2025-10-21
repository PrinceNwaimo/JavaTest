package diettelGenericDataStructures;

import java.util.Random;

public class TreeNode4 {
    int data;
    TreeNode4 left;
    TreeNode4 right;

    public TreeNode4(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree2 {
    TreeNode4 root;

    public BinarySearchTree2() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private TreeNode4 insertRecursive(TreeNode4 root, int data) {
        if (root == null) {
            return new TreeNode4(data);
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }
        return root;
    }

    public int getDepth() {
        return getDepthRecursive(root);
    }

    private int getDepthRecursive(TreeNode4 node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepthRecursive(node.left);
        int rightDepth = getDepthRecursive(node.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public void inorderTraversal() {
        System.out.println("Inorder Traversal:");
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(TreeNode4 root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }
}

