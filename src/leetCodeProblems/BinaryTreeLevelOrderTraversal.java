package leetCodeProblems;
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();

        if (root == null) {
            return levelOrderTraversal;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                level.add(node.value);

                if (node.left!= null) {
                    q.offer(node.left);
                }
                if (node.right!= null) {
                    q.offer(node.right);
                }
            }
            levelOrderTraversal.add(level);
        }

        return levelOrderTraversal;
    }

    public static void main(String[] args) {
        // Example tree:
        // 3
        // / \
        // 9 20
        // / \
        // 15 7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = sol.levelOrder(root);

        System.out.println(result); // Output: [[3], [9, 20], [15, 7]]
    }
}
