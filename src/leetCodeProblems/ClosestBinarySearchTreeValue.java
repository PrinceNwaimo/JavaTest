package leetCodeProblems;

public class ClosestBinarySearchTreeValue {
    private double minDiff = Double.MAX_VALUE;
    private int closestValue;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return closestValue;
    }

    private void helper(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        double diff = Math.abs(root.value - target);
        if (diff < minDiff) {
            minDiff = diff;
            closestValue = root.value;
        }

        // BST property: go left if target < node, else go right
        if (target < root.value) {
            helper(root.left, target);
        } else if (target > root.value) {
            helper(root.right, target);
        }
        // if target == root.val, we already found exact match
    }
}
