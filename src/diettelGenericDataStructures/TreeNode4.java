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
    public void deleteNode(int value) {
        root = deleteNodeRecursive(root, value);
    }

    private TreeNode4 deleteNodeRecursive(TreeNode4 root, int value) {
        if (root == null) {
            System.out.println("Value " + value + " not found in the tree.");
            return null;
        }

        if (value < root.data) {
            root.left = deleteNodeRecursive(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNodeRecursive(root.right, value);
        } else {
            // Node to delete found
            // Case 1: No children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            else {
                TreeNode4 temp = findMin(root.right); // Find inorder successor
                root.data = temp.data;
                root.right = deleteNodeRecursive(root.right, temp.data);
            }
        }
        return root;
    }

    private TreeNode4 findMin(TreeNode4 node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void preorderTraversal() {
        System.out.println("Preorder Traversal:");
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(TreeNode4 root) {
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

    private void postorderRecursive(TreeNode4 root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }
    public Integer contains(int searchKey) {
        return containsRecursive(root, searchKey);
    }

    private Integer containsRecursive(TreeNode4 node, int searchKey) {
        if (node == null) {
            return null; // Base case: not found
        }

        if (searchKey < node.data) {
            return containsRecursive(node.left, searchKey);
        } else if (searchKey > node.data) {
            return containsRecursive(node.right, searchKey);
        } else {
            return node.data; // Found match
        }
    }
    public void outputTree(int totalSpaces) {
        outputTreeRecursive(root, totalSpaces);
    }

    private void outputTreeRecursive(TreeNode4 node, int totalSpaces) {
        if (node != null) {
            outputTreeRecursive(node.right, totalSpaces + 5); // Traverse right subtree
            for (int i = 0; i < totalSpaces; i++) {
                System.out.print(" ");
            }
            System.out.println(node.data);          // Visit node (print data)
            outputTreeRecursive(node.left, totalSpaces + 5);  // Traverse left subtree
        }
    }
}

