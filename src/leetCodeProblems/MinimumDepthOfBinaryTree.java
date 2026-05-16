package leetCodeProblems;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // If one child is None, must consider the depth of the other child
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = (root.left != null) ? minDepth(root.left) : Integer.MAX_VALUE;
        int right = (root.right != null) ? minDepth(root.right) : Integer.MAX_VALUE;

        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree solver = new MinimumDepthOfBinaryTree();

        // Example tree:
        //    1
        //   / \
        // 2   3
        // /
        //4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(4);

        int depth = solver.minDepth(root);
        System.out.println("Minimum depth: " + depth); // Output: 2
    }
}
