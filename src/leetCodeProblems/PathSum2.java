package leetCodeProblems;

import java.util.*;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(new ArrayList<>(List.of(root.value)));
        stack.push(root.value);

        while (!stack.isEmpty()) {
            int pathSum = (int) stack.pop();
            List<Integer> path = (List<Integer>) stack.pop();
            TreeNode current = (TreeNode) stack.pop();

            if (current.left == null && current.right == null && pathSum == sum) {
                paths.add(path);
            }

            if (current.right != null) {
                List<Integer> rightPath = new ArrayList<>(path);
                rightPath.add(current.right.value);
                stack.push(current.right);
                stack.push(rightPath);
                stack.push(pathSum + current.right.value);
            }

            if (current.left != null) {
                List<Integer> leftPath = new ArrayList<>(path);
                leftPath.add(current.left.value);
                stack.push(current.left);
                stack.push(leftPath);
                stack.push(pathSum + current.left.value);
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        // Build tree correctly:
        //       5
        //      / \
        //     4   8
        //    /   / \
        //   11 13 4
        //  /  \    / \
        // 7    2 5   1

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left = new TreeNode(11);
        root.left = new TreeNode(7);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right = new TreeNode(1);

        int targetSum = 22;

        PathSum2 solution = new PathSum2();
        List<List<Integer>> result = solution.pathSum(root, targetSum);

        System.out.println("Paths that sum to " + targetSum + ":");
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
