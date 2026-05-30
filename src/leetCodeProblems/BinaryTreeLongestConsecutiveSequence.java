package leetCodeProblems;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int maxSize = 1;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sizeQueue = new LinkedList<>();

        nodeQueue.offer(root);
        sizeQueue.offer(1);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int size = sizeQueue.poll();

            if (node.left != null) {
                nodeQueue.offer(node.left);
                if (node.value + 1 == node.left.value) {
                    sizeQueue.offer(size + 1);
                } else {
                    sizeQueue.offer(1);
                }
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                if (node.value + 1 == node.right.value) {
                    sizeQueue.offer(size + 1);
                } else {
                    sizeQueue.offer(1);
                }
            }

            maxSize = Math.max(maxSize, size);
        }

        return maxSize;
    }

    public static void main(String[] args) {
        /*
              1
               \
                3
               / \
              2   4
               \
                5
        Longest consecutive: 3->4->5 = 3
        */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        BinaryTreeLongestConsecutiveSequence sol = new BinaryTreeLongestConsecutiveSequence();
        int result = sol.longestConsecutive(root);

        System.out.println("Longest consecutive sequence length: " + result); // Output: 3
    }
}
