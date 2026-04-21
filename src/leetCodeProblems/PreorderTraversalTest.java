package leetCodeProblems;

import java.util.List;

public class PreorderTraversalTest {
    public static void main(String[] args) {
        // Build test tree: 1 -> 2,3 and 2 -> 4,5
        //   1
        //  / \
        // 2   3
        // / \
        //4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PreorderTraversal sol = new PreorderTraversal();
        List<Integer> result = sol.preorderTraversal(root);

        System.out.println(result);
    }
}
