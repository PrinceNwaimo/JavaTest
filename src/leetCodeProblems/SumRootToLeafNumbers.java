package leetCodeProblems;

import java.util.*;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<String> pathStack = new ArrayDeque<>();
        List<Integer> paths = new ArrayList<>();

        nodeStack.push(root);
        pathStack.push(String.valueOf(root.value));

        while (!nodeStack.isEmpty()) {
            String path = pathStack.pop();
            TreeNode current = nodeStack.pop();

            // Leaf node
            if (current.left == null && current.right == null) {
                paths.add(Integer.parseInt(path));
            }

            if (current.right != null) {
                nodeStack.push(current.right);
                pathStack.push(path + current.right.value);
            }
            if (current.left != null) {
                nodeStack.push(current.left);
                pathStack.push(path + current.left.value);
            }
        }

        int sum = 0;
        for (int num : paths) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
        Paths: 12, 13
        Sum: 25
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        SumRootToLeafNumbers sol = new SumRootToLeafNumbers();
        int result = sol.sumNumbers(root);

        System.out.println("Sum of root-to-leaf numbers: " + result); // Output: 25
    }
}
