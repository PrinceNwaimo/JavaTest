package leetCodeProblems;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        // Test: Tree = [3,9,20,null,null,15,7]
        //      3
        //     / \
        //    9  20
        //       / \
        //      15  7
        // Max depth = 3

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
        int depth = sol.maxDepth(root);

        System.out.println("Max Depth: " + depth); // Max Depth: 3

        // Test empty tree
        System.out.println("Empty tree: " + sol.maxDepth(null)); // Empty tree: 0
    }
}
