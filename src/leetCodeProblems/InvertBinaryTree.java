package leetCodeProblems;
import java.util.*;

public class InvertBinaryTree {
    public void invertTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();

            // Swap left and right
            TreeNode temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;

            // Push children if they exist
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
            if (currNode.right != null) {
                stack.push(currNode.right);
            }
        }
    }

    // Helper to print level order for testing
    public void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test: Tree = [4,2,7,1,3,6,9]
        //      4           4
        //     / \   =>    / \
        //    2   7       7   2
        //   / \ / \     / \ / \
        //  1  3 6  9   9  6 3  1

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertBinaryTree sol = new InvertBinaryTree();

        System.out.print("Before: ");
        sol.printLevelOrder(root); // 4 2 7 1 3 6 9

        sol.invertTree(root);

        System.out.print("After:  ");
        sol.printLevelOrder(root); // 4 7 2 9 6 3 1
    }
}
