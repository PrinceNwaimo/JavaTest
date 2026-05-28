package leetCodeProblems;
import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();

        if (root == null) {
            return rightSideView;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // use null as level delimiter instead of "#"

        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                if (!level.isEmpty()) {
                    rightSideView.add(level.get(level.size() - 1));
                }
                level.clear();

                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                level.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return rightSideView;
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
             \    \
              5    4
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(4);

        BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
        List<Integer> result = sol.rightSideView(root);

        System.out.println("Right side view: " + result); // Output: [1, 3, 4]
    }
}
