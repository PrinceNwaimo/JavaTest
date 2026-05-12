package leetCodeProblems;
import java.util.Stack;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        nodeStack.push(root);
        sumStack.push(root.value);

        while (!nodeStack.isEmpty()) {
            int currentSum = sumStack.pop();
            TreeNode current = nodeStack.pop();

            // Check if it's a leaf and sum matches
            if (current.left == null && current.right == null && currentSum == targetSum) {
                return true;
            }

            if (current.right != null) {
                nodeStack.push(current.right);
                sumStack.push(currentSum + current.right.value);
            }
            if (current.left != null) {
                nodeStack.push(current.left);
                sumStack.push(currentSum + current.left.value);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        /*
           Example tree:
                  5
                 / \
                4   8
               /   / \
              11 13 4
             /  \      \
            7    2      1
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left = new TreeNode(11);
        root.left = new TreeNode(7);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right = new TreeNode(4);
        root.right = new TreeNode(1);

        PathSum solver = new PathSum();
        int target = 22;

        boolean result = solver.hasPathSum(root, target);
        System.out.println("Has path sum " + target + ": " + result); // true
    }
}
