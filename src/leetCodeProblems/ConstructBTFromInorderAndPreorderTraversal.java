package leetCodeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBTFromInorderAndPreorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        return createTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private int searchDivIndex(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode createTree(int[] inorder, int inStart, int inEnd,
                                int[] preorder, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int divIndex = searchDivIndex(inorder, inStart, inEnd, preorder[preStart]);

        int sizeLeft = divIndex - inStart;

        root.left = createTree(inorder, inStart, divIndex - 1, preorder, preStart + 1, preStart + sizeLeft);
        root.right = createTree(inorder, divIndex + 1, inEnd, preorder, preStart + sizeLeft + 1, preEnd);

        return root;
    }

    // Helper to print tree level order for verification
    private void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.value + " ");
            if (node.left!= null) q.offer(node.left);
            if (node.right!= null) q.offer(node.right);
        }
    }

    public static void main(String[] args) {
        ConstructBTFromInorderAndPreorderTraversal sol = new ConstructBTFromInorderAndPreorderTraversal();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = sol.buildTree(preorder, inorder);

        System.out.print("Level order of constructed tree: ");
        sol.printLevelOrder(root);
        // Output: 3 9 20 15 7
    }
}
