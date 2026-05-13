package leetCodeProblems;

public class BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    private int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));

        maxSum = Math.max(maxSum, left + right + root.value);

        return Math.max(left, right) + root.value;
    }

    public static void main(String[] args) {
        // Example: [1,2,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        BinaryTreeMaxPathSum solver = new BinaryTreeMaxPathSum();
        int result = solver.maxPathSum(root);

        System.out.println("Max Path Sum: " + result); // Output: 6
    }
}
