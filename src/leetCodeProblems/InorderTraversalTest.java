package leetCodeProblems;

import java.util.List;

public class InorderTraversalTest {
    public static void main(String[] args) {
        // Test tree:    1
        //                \
        //                 2
        //                /
        //               3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        InorderTraversal sol = new InorderTraversal();
        List<Integer> res = sol.inorderTraversal(root);

        System.out.println(res); // [1, 3, 2]
    }
}
