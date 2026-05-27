package leetCodeProblems;
import java.util.*;

public class BinaryLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        if (root == null) {
            return levelOrderTraversal;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // sentinel for end of level

        List<Integer> level = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                stack.push(new ArrayList<>(level));
                level.clear();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                level.add(current.value);
                if (current.left!= null) {
                    queue.offer(current.left);
                }
                if (current.right!= null) {
                    queue.offer(current.right);
                }
            }
        }

        while (!stack.isEmpty()) {
            levelOrderTraversal.add(stack.pop());
        }
        return levelOrderTraversal;
    }

    public static void main(String[] args) {
        // Build tree: [3,9,20,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right = new TreeNode(7);

        BinaryLevelOrderTraversal2 solution = new BinaryLevelOrderTraversal2();
        List<List<Integer>> result = solution.levelOrderBottom(root);

        System.out.println("Bottom-up Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
        // Output: [[15, 7], [9, 20], [3]]
    }
}
