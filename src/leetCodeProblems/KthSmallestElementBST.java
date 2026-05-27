package leetCodeProblems;
import java.util.Stack;

public class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            // Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Pop and process
            current = stack.pop();
            k--;

            if (k == 0) {
                return current.value;
            }

            // Move to right subtree
            current = current.right;
        }

        throw new IllegalArgumentException("k is larger than number of nodes");
    }

    public static void main(String[] args) {
        // Build BST: [3,1,4,null,2]
        //        3
        //       / \
        //      1   4
        //       \
        //        2

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementBST solution = new KthSmallestElementBST();

        int k = 1;
        System.out.println(k + "st smallest: " + solution.kthSmallest(root, k)); // 1

        k = 3;
        System.out.println(k + "rd smallest: " + solution.kthSmallest(root, k)); // 3
    }
}
