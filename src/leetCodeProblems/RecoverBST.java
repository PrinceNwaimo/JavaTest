package leetCodeProblems;

public class RecoverBST {
    private TreeNode prev = null;
    private TreeNode node1 = null;
    private TreeNode node2 = null;

    public void recoverTree(TreeNode root) {
        recoverTreeHelper(root);

        // Swap the values of the two misplaced nodes
        if (node1 != null && node2 != null) {
            int temp = node1.value;
            node1.value = node2.value;
            node2.value = temp;
        }
    }

    private void recoverTreeHelper(TreeNode root) {
        if (root == null) return;

        recoverTreeHelper(root.left);

        // Check for violation in-order sequence
        if (prev != null && prev.value > root.value) {
            if (node1 == null) {
                node1 = prev;  // First violation
            }
            node2 = root;      // Second violation - always update
        }
        prev = root;

        recoverTreeHelper(root.right);
    }

    // Helper to print in-order for testing
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Build tree: [3,1,4,null,2]
        //      3
        //     / \
        //    1   4
        //       /
        //      2   <- 2 and 3 are swapped
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        RecoverBST sol = new RecoverBST();

        System.out.print("Before: ");
        sol.inorder(root);
        System.out.println();

        sol.recoverTree(root);

        System.out.print("After: ");
        sol.inorder(root);
        System.out.println();
        // Output: After: 1 2 3 4
    }
}
