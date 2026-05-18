package leetCodeProblems;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        return helper(numbers, 0, numbers.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2; // avoids overflow
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST solution = new ConvertSortedArrayToBST();

        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);

        System.out.println("BST root value: " + root.value); // should print 0
    }

    // Helper to verify the tree with inorder traversal
    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }
}
