package leetCodeProblems;
import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        // Stack stores pairs of [path, node]. Use Deque for stack behavior
        Deque<Object> stack = new ArrayDeque<>();
        stack.push(root);
        stack.push(String.valueOf(root.value));

        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();

            // If leaf, add path
            if (node.left == null && node.right == null) {
                paths.add(path);
            }

            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.value);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.value);
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        // Build example tree:
        //    1
        //   / \
        // 2   3
        //   \
        //    5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths sol = new BinaryTreePaths();
        List<String> result = sol.binaryTreePaths(root);

        System.out.println("All root-to-leaf paths:");
        for (String path : result) {
            System.out.println(path);
        }
        // Output:
        // 1->2->5
        // 1->3
    }
}
