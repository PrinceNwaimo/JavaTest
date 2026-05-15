package leetCodeProblems;

public class ValidateBinarySearchTree {
    private long lastPrinted = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Check left subtree
        if (!isValidBST(root.left)) {
            return false;
        }

        // Check current node
        if (root.value <= lastPrinted) {
            return false;
        }
        lastPrinted = root.value;

        // Check right subtree
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        // Test case: Valid BST
        //    2
        //   / \
        // 1   3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();
        System.out.println(sol.isValidBST(root)); // true

        // Test case: Invalid BST
        //    5
        //   / \
        // 1   4
        //     / \
        //    3   6
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right = new TreeNode(6);

        ValidateBinarySearchTree sol2 = new ValidateBinarySearchTree();
        System.out.println(sol2.isValidBST(root2)); // false
    }
}
