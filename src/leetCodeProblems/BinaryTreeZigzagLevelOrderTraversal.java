package leetCodeProblems;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();

        if (root == null) {
            return levelOrderTraversal;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // null as level delimiter
        List<Integer> level = new ArrayList<>();
        int levelNo = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                if (!level.isEmpty()) {
                    if (levelNo % 2 == 0) {
                        levelOrderTraversal.add(new ArrayList<>(level));
                    } else {
                        Collections.reverse(level);
                        levelOrderTraversal.add(new ArrayList<>(level));
                    }
                    level.clear();
                    levelNo++;
                }

                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                level.add(node.value);
                if (node.left!= null) {
                    queue.offer(node.left);
                }
                if (node.right!= null) {
                    queue.offer(node.right);
                }
            }
        }

        return levelOrderTraversal;
    }

    public static void main(String[] args) {
        /*
              3
             / \
            9 20
              / \
             15 7
        Output: [[3], [20, 9], [15, 7]]
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right = new TreeNode(7);

        BinaryTreeZigzagLevelOrderTraversal sol = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> result = sol.zigzagLevelOrder(root);

        System.out.println("Zigzag level order: " + result);
    }
}
