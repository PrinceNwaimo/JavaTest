package leetCodeProblems;
import java.util.*;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> outList = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            outList.add(current.value);

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        Collections.reverse(outList);
        return outList;
    }

    public static void main(String[] args) {
        // Test: Tree = 1, 2, 3, null, null, 4, 5
        //      1
        //     / \
        //    2   3
        //       / \
        //      4   5
        // Postorder = [2, 4, 5, 3, 1]

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        PostOrderTraversal sol = new PostOrderTraversal();
        List<Integer> result = sol.postorderTraversal(root);

        System.out.println(result); // [2, 4, 5, 3, 1]
    }
}
