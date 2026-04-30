package leetCodeProblems;

public class BalancedBinaryTreeTest {
    public static void main(String[] args) {
        // Test 1: Balanced tree
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        BalancedBinaryTree sol = new BalancedBinaryTree();
        System.out.println(sol.isBalanced(root1)); // true

        // Test 2: Unbalanced tree
        //       1
        //      / \
        //     2   2
        //    / \
        //   3   3
        //  / \
        // 4   4
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);

        System.out.println(sol.isBalanced(root2)); // false
    }
}
