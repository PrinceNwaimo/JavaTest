package leetCodeProblems;

public class SymmetricTreeTest {
    public static void main(String[] args) {
        // Test 1: Symmetric tree
        //     1
        //    / \
        //   2   2
        //  / \ / \
        // 3  4 4  3
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        SymmetricTree sol = new SymmetricTree();
        System.out.println(sol.isSymmetric(root1)); // true

        // Test 2: Not symmetric
        //     1
        //    / \
        //   2   2
        //    \   \
        //     3   3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println(sol.isSymmetric(root2)); // false
    }
}
